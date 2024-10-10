# Documentation Tâche 2 (Jsoup)


## Liste de tests ajoutés par notre équipe

## org.jsoup.parser
Dans ce package nous avons d'abord travailler sur "HtmlTreeBuilderState.java" puisque c'était là qu'il y avait le plus d'instructions et de branches non-couvertes selon le rapport de couverture. On a alors ajouté 5 nouveaux tests unitaires dans le fichier "HtlmTreeBuilderState.java" :
### 1. testNestedFrameset
Ce test vérifie que les balises <frameset> imbriqués sont correctement gérés pour assurer la compatibilité avec les anciens contenus HTML utilisant des framesets.
### 2. testTableCaption
Ce test vérifie que l'analyseur identifie et stock de bonne manière la balise <caption> dans une table pour assurer une bonne accessibilité et sémantique des tableaux.
### 3. testTableColgroup
Ce test vérifie la bonne gestion des balises <colgroup> et <col> pour maintenir la structure des tableaux.
### 4. testSingleForm
Ce test vérifie qu'un seul élément <form> est conservé même avec plusieurs formulaires imbriqués pour respecter les standards de HTML.
### 5. testIsindexHandling
Ce test vérifie la conversion de la balise obsolète <isindex> en formulare pour guarantir la compatibilité avec les ancients documents HTML.

## org.jsoup.helper 

Dans ce package nous avons travaillé sur le fichier `ValidateTest.java` sur la méthode `testNotEmpty()`.
Le test verifie si la méthod NotEmpty() retourne bien les bon résultats même si le string est vide ou null.


[testNotEmpty()](https://github.com/YellowKappa/jsoup/blob/master/src/test/java/org/jsoup/helper/ValidateTest.java)

Ce test permet de vérifier si la méthode `parseInputStreamTest()` du fichier `DataUtil.java` ne retourne pas null quand le document input est vide.
Si le document est vide, il faut que le document résultant ne contient rien.

[parseInputStreamTest()](https://github.com/YellowKappa/jsoup/blob/master/src/test/java/org/jsoup/helper/DataUtilTest.java)

## org.jsoup.internal

Dans ce package, nous avons travaillé sur le fichier `SimpleBufferedTest.java` sur la méthode `testReadAfterEndOfStream()` et `testMarkAndReset()`.


[testMarkAndReset()](https://github.com/YellowKappa/jsoup/blob/master/src/test/java/org/jsoup/internal/SimpleBufferedTest.java)
[testReadAfterEndOfStream()](https://github.com/YellowKappa/jsoup/blob/master/src/test/java/org/jsoup/internal/SimpleBufferedTest.java)

## org.jsoup.parser
Dans ce package, nous avons travaillé sur le fichier CharacterReaderTest.java sur la méthode `testCloseWhenReaderIsAlreadyNull()`.
Le test permet de vérifier le fonctionnement de la méthode quand elle doit fermer un reader déjà fermé. 

[testCloseWhenReaderIsAlreadyNull()](https://github.com/YellowKappa/jsoup/blob/master/src/test/java/org/jsoup/parser/CharacterReaderTest.java)


