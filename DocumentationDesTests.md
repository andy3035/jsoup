# Documentation Tâche 2 (Jsoup)


## Liste de tests ajoutés par notre équipe

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


