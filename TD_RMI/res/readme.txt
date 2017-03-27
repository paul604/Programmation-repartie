========================================
                TP RMI
Configuration de l'environnement pour le serveur RMI
Christian Attiogbe, mars 2015, U. Nantes

============= Architecture de l'appli===
Serveur                | Client
 -  monInterfaceDistant.java // interface
 -  monObjetAccessibleDistance // objet distant
 -  testSRVTPrmi.java // contient le main qui cree l'objet et qui le publie

Client
 -  clientRmi.java // recupere l'objet distant, et appelle une de ses methodes

=============cote serveur===============
%--- compilation des classes et generation des stub/skel
    javac monInterfaceDistant.java
    javac monObjetAccessibleDistance.java
    rmic monObjetAccessibleDistance

    javac testSRVTPrmi.java  // mon serveur

%--- Prevoir un emplacement accessible à distance (pour les clients du rmi...)
 par exemple /home/MOI/public_html  (qui est le classique pour http)
   en dessous (prevoir) un sous-repertoire classes/ pour recevoir les .jar ...

%--- creer pour l'appli RMI, une archive avec les interfaces à charger/partager
   jar cvf monInterfaceDistant.jar monInterfaceDistant.class
   jar cvf monObjetAccessibleDistance.jar monObjetAccessibleDistance.class

   copie des .jar vers l'archive dans /home/MOI/public_html/classes/.

%---- n'oublier pas de lancer le
   rmiregisty &

%------ lancement du serveur en lui precisant le classpath et le codebase
java -cp /home/MOI/TP1RMI/:home/MOI/TP1RMI/monObjetAccessibleDistance.jar -Djava.rmi.server.codebase=file:///home/MOI/public_html/classes/ -Djava.security.policy=client.policy testSRVTPrmi

java -cp ~/info2/prog_reparti/TD_RMI/jar/:~/info2/prog_reparti/TD_RMI/jar/monObjetAccessibleDistance.jar -Djava.rmi.server.codebase=file://~/info2/prog_reparti/TD_RMI/jar/ -Djava.security.policy=client.policy ~/info2/prog_reparti/TD_RMI/out/production/TD_RMI/serveur/testSRVTPrmi

java -cp ../../../jar/:../../../jar/monObjetAccessibleDistance.jar -Djava.security.policy=client.policy serveur/testSRVTPrmi

java -cp ../../../../jar/:../../../../jar/monObjetAccessibleDistance.jar -Djava.security.policy=client.policy testSRVTPrmi

==============cote client===============
Rien de special à faire

%--- compiler l'appli client
  javac clientRmi.java

%--- executer l'appli client
  java clientRmi

========================================
    /!\

Si pbm de binding cote serveur
 ==> les classpath, codebase ne sont pas corrects

Si pbm de magic number ==> les .jar ne sont pas à jour
  recompiler

Pour pus d'info, consulter
  http://docs.oracle.com/javase/tutorial/rmi/running.html
  http://docs.oracle.com/javase/7/docs/technotes/guides/rmi/codebase.html
========================================
