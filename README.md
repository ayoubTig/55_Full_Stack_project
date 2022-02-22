# Description de projet: #

Ce projet consiste à afficher les scores des joueurs, il a été réalisé pour récupper les données deuips un API et de le traiter puis de les mettre à disposition comme un web service. il compose de deux parties:<br/>
    1. Partie back-end: réalisé avec JAVA et jersy comme des libraires d'implémentation de web service sous Tomcat 9, il sert à récupérer les données de l'URL fournie, et les traiter selon format requis pour les fonctionnalités front-end.<br/>
     2. Partie front-end: composé de HTML, JS et Css pour afficher les données sous format d'Histogarmme sans JS libraire. <br/>

## Déploiement:  ##

Le web service peut étre déployé se format d'un war directement dans Web serveur Tomcat9, soit de le coloner depuis le dépot et de l'utiliser sous IDE.
Pour la partie front vous devez changer la variable URL et de l'adapter à votre url pour l'acces au service. une fois vous lancer le web service vous pouvez vérifer est il tourne parfaitement http://localhost:8080/testAPI/api/login  il va afficher les données sous format de JSON.




##### Les histogrammes pour la comparaison des résultats : 

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/HistogrammeLarry.PNG)

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/Histogramme_John.PNG)


