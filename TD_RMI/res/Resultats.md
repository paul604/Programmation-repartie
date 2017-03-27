# Résultats du TD RMI

## Etude de cas 1

1. Le serveur dispose d'une map avec le nom des équipes et leur score.
    Les clients récupèrent les équipes et leur score. Ils récupèrent aussi les méthodes lié à l'objet équipe.
    Plus précisément:
    - Le client récupère l'objet `Rank` qui contient une `SortedMap<String, Integer>` qui met en relation le nom de l’équipe et son score.
    - L'objet `Rank` implémente l'interface `IRank` qui contient des méthodes comme `getEquipe(nom)`, `getRank()`.

2. voir Petri1.

## Etude de cas 2

1. idem que le cas 1 mais un serveur ne dispose pas des score de toute les equipe.

2. voir Perti2. (il faudrait ajouter une exclusion pour tout les serveur
pour éviter un interblocage si le serveur 1 demande le serveur 2 et inversement en même temps)