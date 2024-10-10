package org.jsoup.parser;

import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.HtmlTreeBuilderState.Constants;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jsoup.parser.HtmlTreeBuilderState.Constants.InBodyStartInputAttribs;
import static org.junit.jupiter.api.Assertions.*;

public class HtmlTreeBuilderStateTest {
    static List<Object[]> findConstantArrays(Class aClass) {
        ArrayList<Object[]> array = new ArrayList<>();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) && !Modifier.isPrivate(modifiers) && field.getType().isArray()) {
                try {
                    array.add((Object[]) field.get(null));
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        return array;
    }

    

    static void ensureSorted(List<Object[]> constants) {
        for (Object[] array : constants) {
            Object[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            assertArrayEquals(array, copy);
        }
    }

    // Vérifier les balises <frameset> imbriqués
    @Test
    public void testNestedFrameset() {
        // Arrange
        String html = "<frameset><frameset><frame></frameset></frameset>";

        // Act
        String parsed = Jsoup.parse(html).toString();

        // Assert
        assertTrue(parsed.contains("<frame>"));
    }

    // Vérifier la balise <caption> dans une table
    @Test
    public void testTableCaption() {
        // Arrange
        String html = "<table><caption>Caption Content</caption></table>";

        // Act
        Document doc = Jsoup.parse(html);

        // Assert
        assertNotNull(doc.selectFirst("caption"));
        assertEquals("Caption Content", doc.selectFirst("caption").text());
    }

    // Vérifier les balises <colgroup> et <col> dans une table
    @Test
    public void testTableColgroup() {
        // Arrange
        String html = "<table><colgroup><col></colgroup></table>";

        // Act
        Document doc = Jsoup.parse(html);

        // Assert
        assertNotNull(doc.selectFirst("colgroup"));
        assertNotNull(doc.selectFirst("col"));
    }

    // Vérifier qu'il n'y a qu'un seul <form> même s'il est imbriqué
    @Test
    public void testSingleForm() {
        // Arrange
        String html = "<form><div><form></form></div></form>";

        // Act
        Document doc = Jsoup.parse(html);

        // Assert
        assertEquals(1, doc.select("form").size());
    }

    // Vérifier la gestion de la balise <isindex> et sa conversion en formulaire
    @Test
    public void testIsindexHandling() {
        // Arrange
        String html = "<isindex prompt='Search here'>";

        // Act
        Document doc = Jsoup.parse(html);

        // Assert
        assertNotNull(doc.selectFirst("form"));
        assertNotNull(doc.selectFirst("input[name=isindex]"));
        assertEquals("Search here", doc.selectFirst("label").text());
    }

    @Test
    public void ensureArraysAreSorted() {
        List<Object[]> constants = findConstantArrays(Constants.class);
        ensureSorted(constants);
        assertEquals(40, constants.size());
    }

    @Test public void ensureTagSearchesAreKnownTags() {
        List<Object[]> constants = findConstantArrays(Constants.class);
        for (Object[] constant : constants) {
            String[] tagNames = (String[]) constant;
            for (String tagName : tagNames) {
                if (StringUtil.inSorted(tagName, InBodyStartInputAttribs))
                    continue; // odd one out in the constant
                assertTrue(Tag.isKnownTag(tagName), String.format("Unknown tag name: %s", tagName));
            }
        }
    }


    @Test
    public void nestedAnchorElements01() {
        String html = "<html>\n" +
            "  <body>\n" +
            "    <a href='#1'>\n" +
            "        <div>\n" +
            "          <a href='#2'>child</a>\n" +
            "        </div>\n" +
            "    </a>\n" +
            "  </body>\n" +
            "</html>";
        String s = Jsoup.parse(html).toString();
        assertEquals("<html>\n" +
            " <head></head>\n" +
            " <body>\n" +
            "  <a href=\"#1\"> </a>\n" +
            "  <div>\n" +
            "   <a href=\"#1\"> </a><a href=\"#2\">child</a>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>", s);
    }

    @Test
    public void nestedAnchorElements02() {
        String html = "<html>\n" +
            "  <body>\n" +
            "    <a href='#1'>\n" +
            "      <div>\n" +
            "        <div>\n" +
            "          <a href='#2'>child</a>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    </a>\n" +
            "  </body>\n" +
            "</html>";
        String s = Jsoup.parse(html).toString();
        assertEquals("<html>\n" +
            " <head></head>\n" +
            " <body>\n" +
            "  <a href=\"#1\"> </a>\n" +
            "  <div>\n" +
            "   <a href=\"#1\"> </a>\n" +
            "   <div>\n" +
            "    <a href=\"#1\"> </a><a href=\"#2\">child</a>\n" +
            "   </div>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>", s);
    }

}
