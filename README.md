# Coding dojo Docker

##  Présentation de docker 
### Introduction 
Docker s'est installé sur le marché pour répondre à de nombreux besoins de développeurs en terme de production, en effet le passage de plateforme de développement aux environnements de recette par exemple, peuvent génèrer des bugs au sein des applications. La question était donc de pouvoir proposer un outil pour pouvoir permettre un passage serein d'un environnement à un autre et cela de manière la plus simple pour l'utilisateur ( aucun besoin d'installation de quelque configuration que ce soit).
###  Premiers pas sur un ubuntu de l'innovation

Découverte de l'outil, création d'un conteneur ubuntu à l'aide de l'onglet services de la plateforme de l'innovation Onyxia:

- configuration : https://onyxia.beta.innovation.insee.eu/mon-compte onglet : "renouveler la clé ssh" 
- Lancement d'une machine virtuelle ubuntu sur : https://onyxia.beta.innovation.insee.eu/my-lab/catalogue   rechercher : ubuntu


#### Premieres expériences avec l'univers docker
Une fois arrivés sur le conteneur ubuntu 
(mot de passe = changeMe)


- Ouvrir un terminal  puis ajoutez la commande ```docker run hello-world``` 
- Testez la commande suggérée dans votre terminal

## Le DockerFile et les images docker
### Introduction
Une image docker est décrite dans un fichier ```Dockerfile```.  
Un Dockerfile commence par une instruction FROM indiquant l'image de base de laquelle on repart.  
Par exemple :  
```Dockerfile
FROM openjdk:8-jdk-alpine
```  
est un Dockerfile valide correspondant exactement à l'image du openjdk 8.  
On peut ensuite enchainer différentes commandes pour compléter l'environnement :  
```RUN```, ```ADD```, ```ENV``` ... Les différentes commandes sont documentées ici : [https://docs.docker.com/engine/reference/builder/](https://docs.docker.com/engine/reference/builder/)
### Creation d'un DockerFile
Effectuez un fork du projet disponible sur https://git.stable.innovation.insee.eu/groupe_application_SNDIO/coding_dojo_docker sur le conteneur ubuntu.

puis importez le en effectuant la commande suivante :
```git clone  "LIEN DU PROJET"``` (le lien du projet étant disponible en haut a droite de votre fork)

Nous allons construire une image docker pour le serveur du projet ensemble : 
- Partir d'une image openjdk 8 alpine (pour que spring boot fasse son office)
- Copier le bon war/jar
- Mapper le port 8080
- Rendre votre image docker executable (lancement automatique du server spring boot #ENTRYPOINT )

https://docs.docker.com/engine/reference/builder/ doc officielle

### Creation d'une image à l'aide de ce DockerFile
En fait, tout le travail est déjà fait, il ne reste qu'a build et lancer notre image docker
- ```docker build -t nomImage .```
- ```docker run -p 8080:8080 nomImage ```

On peut également la poster sur le registry de l'insee ( car il faut un compte pour DockerHub) en effectuant les commandes suivantes : 
-  ```docker build -t https://docker-registry.beta.innovation.insee.eu/test/nomImage```
- ```docker push https://docker-registry.beta.innovation.insee.eu/test/nomImage```

et l'éxécuter directement depuis votre ubuntu avec : 
```docker run -p 8080:8080 https://docker-registry.beta.innovation.insee.eu/test/nomImage```
## GitLab CI
### Introduction
Le fichier .gitlab-ci.yml présent à la racine du projet permet de programmer des jobs qu'on souhaite lancer à chaque push.
> yml <=> json
##### stages
Les "stages" sont les étapes, elles permettent d'ordonner les jobs, les jobs d'une même étape peuvent s'exécuter en parallèle, on a habituellement les étapes build -> test -> deploy
#####  variables
On définit les variables utilisées plus tard dans la section variables, notamment l'endroit où on dépose les images docker qu'on va construire, à l'heure actuelle, les images sont déposées sur docker-registry.beta.innovation.insee.eu
##### job
Pour chaque job, on lui définit un nom, puis on précise le stage, le tags (maven pour tomcat et java, shell pour postgres), les scripts pour build l'image docker ou pour la déployer.
Pour construire une image Tomcat, d'abord on doit créer un war à partir du code source avec la commande mvn package, ensuite on construit l'image docker avec la commande docker build lancée depuis le dossier où se trouve le fichier Dockerfile qui précise les spécifications de l'image, puis on envoie l'image construite sur docker-registry.
### Etablissement d'un pipeline pour l'application
(vous pouvez désormais travailler sur votre poste en réimportant le projet )
- Vous trouverez a la racine un fichier nommé ```gitLab-ci-example.yml```, renommez le en ```gitLab-ci.yml```, cet acronyme ainsi que son positionnement a la Racine indique au service de gitLab que vous désirez utiliser le service du CI.
- Observez le contenu du fichier, vous pouvez maintenant effectuer l'étape hello-world en faisant imprimer le message que vous souhaitez a votre conteneur ubuntu qui tournera le pipeline à l'aide de la commande ECHO, très connue des memeurs.
- En vous inspirant des différentes étapes de construction et deploiement que vous avez effectué avec le dockerFile, vous pouvez maintenant ajouter les quelques lignes de code nécessaires au bon fonctionnement du pipeline donc en la livraison en continu de vos images dockers sur Marathon.
- Effectuez un commit sur votre fork avec les commandes : 
```git add . ``` , ```git commit -m "Message"```, ```git push``` 
(C'est ici qu'on va se faire taper dessus par l'innovation, CHUT)
- Observez votre pipeline tourner (et peut etre mourir).
## Marathon
### Introduction
Les images dockers sont ensuite déployées sur http://deploy.beta.innovation.insee.eu selon les paramètres définis dans les fichiers marathon.json et marathon-pgsql.json à la racine du projet. Comme les images ne sont pas détruites après déploiement (dans la plupart des cas, on les construit pour lancer des tests et on les supprime), le groupe innovation préconise de mettre peu de CPU pour ne pas occuper trop de ressources, en conséquence, le déploiement de Tomcat est très lent et il faut patienter. Les Tomcat doivent être déployés sur dev.innovation.insee.eu . On peut consulter l'état de containers docker sur http://deploy.beta.innovation.insee.eu et même voir des logs Tomcat par exemple.
### Configuration

La configuration se fait dans un fichier ```marathon-group.json``` à la racine du projet dans lequel sont définis les performances de vos différents containers, l'arborescence des containers du projet, les différents ports mappés, et leur cycle de vie.

### Exploration de l'outil
- Rendez vous sur Marathon via Onyxia
- Le coding dojo se trouve dans le fichier coding-dojo-sndio (vous pourrez y retrouver vos containers chéris)
- Vous pouvez par exemple cliquer sur le front pour voir l'ihm du projet tourner sur votre navigateur, sans aucune config a faire c'est cool non ?
> Parenthèse culturelle: c'est comme ça que fonctionne l'innovation en gros.
## SonarQube
### Introduction
SonarQube est un outil de qualimétrie permettant d'évaluer la duplication de code, la couverture de test et d'en faire des statistiques assez intéressantes pour une bonne suivi de projet.
### Utilisation dans un projet
Comme beaucoup de services de l'innovation, on peut utiliser SonarQube et l'intégrer a la livraison en continu par exemple
### Application 
Retournez du côté du fichier .gitlab-ci.yml à la racine du projet, pour y incorporer le SonarQube
#### Biblio
Merci a Olivier Levitt et Zheng Archinard pour leur travail sur le sujet (j'ai un peu récupéré de leur travail, je le concède)