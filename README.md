Description de projet

Ce projet consiste à afficher les scores des joueurs sur un site en ligne spécifique.il a été réalisé pour récupper les données deuips un API et de le traiter puis de les mettre à disposition comme un web service. il compose de deux parties:
    1-Partie back-end: réalisé avec JAVA et jersy comme des libraire d'implémentation de web service sous Tomcat 9, il sert à récupérer les données de l'URL fournie, et les afficher dans le  format requis par les fonctionnalités front-end.
    2-partie front-end: compose de HTML,JS et css pour afficher les données sous format d'Histogarmme sans librire. 
L'explication de code:

Déploiemnet: 

Le web service peut étre déployé se format d'un war directement dans Web serveur Tomcat9, soit de le coloné depuis le dépote et de l'utiliser sous éclipse.
pour la pratie front vous devez changer la variable URL de l'adapter à votre url pour l'acces au service. une fois vous lancer le web service vous pouvez vérifer est il tourne parfaitement http://localhost:8080/testAPI/api/login  il va afficher les données sous format de JSON.



