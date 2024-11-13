
# Documentation Tâche 3 
## Andy Le 20218631

## 1. Test avec -Xmx512m
### Description :
Ce test limite la mémoire maximale alloué au tas Java à 512 Mo. Le tas est l'espace mémoire où les objets Java sont stockés pendant l'exécution.
### Justification:
Ce drapeau a été choisi pour tester la capacité de jsoup à fonctionner dans des environnements à faible mémoire. Cela permet de s'assurer que l'application est optimisée et fonctionne correctement meme avec des ressources limitées.

## 2. Test avec -XX:+UseG1GC
### Description :
Ce test configure la JVM pour utiliser le Garbage Collector G1. Ce collecteur est conçu pour réduire les pauses dues à la gestion de la mémoire.
### Justification:
Ce drapeau a été sélectionné pour tester l'efficacité de la gestion de la mémoire de jsoup lors de tâches intensives, comme l'analyse de documents HTML volumineux. Le collecteur G1 est particulièrement adapté pour des applications nécessitant des temps de pause courts.

## 3. Test avec -XX:+HeapDumpOnOutOfMemoryError
### Description :
Ce drapeau force la JVM à générer un dump mémoire (une capture de l'état de la mémoire) lorsqu'une erreur OutOfMemoryError se produit.
### Justification:
Ce drapeau est utile pour le débogage. Si jsoup rencontre un problème lié à la mémoire, le dump généré permettra d'analyser la cause de l'erreur, comme un problème de fuite de mémoire ou une utilisation inefficace de la mémoire.

## 4. Test avec -XX:+PrintCompilation
### Description :
Ce drapeau active l'affichage des méthodes compilées par le compilateur JIT (Just-In-Time). La compilation JIT optimise le code Java en fonction des performances requises.
### Justification:
Ce drapeau permet d'observer quelles méthodes sont compilées par la JVM et si certaines parties du code jsoup sont intensivement utilisées. Cela peut fournir des informations sur les performances globales et aider à détecter des points de ralenitssement éventuels.

## 5. Test avec -Xlog:gc*
### Description :
Ce drapeau active la journalisation des événements liés à la gestion des déchets (Garbage Collection). Cela inclut les détails sur les cycles de GC, la mémoire récupéré, et la fréquence des collectes.
### Justification:
Ce drapeau permet de surveiller la fréquence et l'efficacité des collectes de déchets pendant les tests. Cela est essentiel pour évaluer les performances de jsoup dans des scénarios où beaucoup d'objets sont créés et détruits (comme le traitement de grandes quantités de texte HTML).

## 6. Petite blague 
### Andy : I'm so sorry my dog ate my homework
### M. Baudry : Your dog ate your coding assignement?
### Andy : Yeah it took him a couple bytes
