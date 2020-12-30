# AndroidProject4A
Created by Elise LLEDO

## Description du projet :

Ce projet est une application android mobile en Kotlin créée sous Android Studio.
Elle est basée sur une clean architecture et de modèle MVVM et l'utilisation de Koin avec une base de donnée construite avec Room

## Lancement de l'application

1. Cloner le projet et l'importer sur Android Studio
2. Lancer l'application sur un émulateur de Android Studio (Exemple Pixar avec Android Pie et API 28)

## Contenu de l'application :

* Page de login

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/login.png" width="200" height="400">  <image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/loginValid.png" width="200" height="400">
  
  
* PopUp avec Message d'erreur Login

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/messageError.png" width="200" height="400"> <image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/messageError2.png" width="200" height="400">
 
 
* Menu

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/menu.png" width="200" height="400">
 
 
* Génération d'une image aléatoire de chat (CatsAPI)

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/imageCat1.png" width="200" height="400">  <image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/imageCat2.png" width="200" height="400">


* Affichage d'une liste d'image de couché de Soleil (récupération images à partir d'URL) puis Zoom sur les photos après clic

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/sunsetList.png" width="200" height="400"> <image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/sunsetListZoom.png" width="200" height="400">


* Affichage d'une liste de version d'Android (DataLocal)

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/androidList2.png" width="200" height="400">


* Génération (visionnage possible) d'une vidéo Youtube (YoutubePlayerAPI)

<image src="https://github.com/SouffleDream/AndroidProject4A/blob/master/Screenshosts/videoYouTube.png" width="200" height="400">



## Notions techniques attendues :

* Language Kotlin / Swift si iOS
* Architecture MVVM
* Clean Architecture
* Utilisation de Koin
* Utilisation d’une réelle BDD
* Utilisation Api REST
* Affichage d’une liste
* Design


## Notions techniques supplémentaires réalisées :

* Mise en place de liste de manière différentes avec des DataSource différentes (Locale et En ligne)
* Mise en place d'un lecteur video à partir d'une API (YouTubePlayerAPI) avec utilisation d'une authentificationKey et de Retrofit
* Blocage des boutons LogIn et Create Account tant qu'ils sont vides ou que le mail n'est pas valide
* Gestion des comptes (Verification existance de l'utilisateur lors de la création de compte et du Login)
* Chargement d'image et Affichage avec l'utilisation de la librairie Picasso


## Potentielles améliorations :

* Ajouter une page pour demander quelle video l'utilisateur aimerait voir
* Optimiser la partie request HTTP/GET pour les api REST
* Ajout de fonctionnalité (gestion de compte avec changement de mot de passe ou chzngement de couleur de thème de l'application)
* Amélioration des architectures (Clean et MVVM)
* Réaliser un page de Création de compte avec plus de champs à remplir 
* Ajouter une option de Captcha

## Projet à tenter :
-> Réalisation d'une application / jeu video


## Aperçu vidéo du projet :

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/t3JRYELXuPQ/0.jpg)](https://www.youtube.com/watch?v=t3JRYELXuPQ)
