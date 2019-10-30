pds_aled_backend : Spring App

Spring fonctionne sous le modèle MVC :
- Modèle
- Vue
- Controller

Ici, nous allons uniquement utilisé Modèle et Controller car la couche Vue

Pour faire fonctionner l'application, il faut :
- Avoir télécharger Postgres en local
- Avoir télécharger le plugin Spring (voir la capture SPRING_PLUGIN.png)
- Modifier ou mettre le mot de passe 'root' pour votre utilisateur 'Postgres' sur pgAdmin
- Créer la database 'application_test' sur Postgres


Pour lancer l'application en local sur Eclipse :
- Maven Clean
- Maven Install
- Run l'application : voir le tutoriel https://stackoverflow.com/questions/23677808/how-to-run-spring-boot-web-application-in-eclipse-itself

Modification pour test Jenkins
