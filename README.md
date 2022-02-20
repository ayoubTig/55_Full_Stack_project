#Description de projet:#

Ce projet consiste à afficher les scores des joueurs sur un site en ligne spécifique il a été réalisé pour récupper les données deuips un API et de le traiter puis de les mettre à disposition comme un web service. il compose de deux parties:
-Partie back-end: réalisé avec JAVA et jersy comme des libraires d'implémentation de web service sous Tomcat 9, il sert à récupérer les données de l'URL fournie, et les afficher dans le  format requis par les fonctionnalités front-end.
-Parties front-end: composé de HTML, JS et Css pour afficher les données sous format d'Histogarmme sans libraire. 

##Déploiemnet: ##

Le web service peut étre déployé se format d'un war directement dans Web serveur Tomcat9, soit de le coloné depuis le dépote et de l'utiliser sous éclipse.
pour la pratie front vous devez changer la variable URL de l'adapter à votre url pour l'acces au service. une fois vous lancer le web service vous pouvez vérifer est il tourne parfaitement http://localhost:8080/testAPI/api/login  il va afficher les données sous format de JSON.




###Les données brutes depuis le source :###

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/databefore.png)
 

#####Les données après le traitement:#####

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/DataAfter.PNG)

#####Les Histogrammes pour la comparasion des données:

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/HistogrammeLarry.PNG)

![alt text](https://github.com/ayoubTig/55_Full_Stack_project/blob/master/imgs/Histogramme_John.PNG)


