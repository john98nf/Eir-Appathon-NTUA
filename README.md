# Eir-Appathon-NTUA
[![MongoDB](https://img.shields.io/badge/MongoDB-v4-green.svg)](https://www.mongodb.com/2)
[![Java](https://img.shields.io/badge/Java-11-yellow.svg)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![SpringBoot](https://img.shields.io/badge/SpringBoot-2.3.2-green.svg)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/AngularCLI-9.1.15-red.svg)](https://angular.io/)
[![TypeScript](https://img.shields.io/badge/TypeScript-3.8.3-blue.svg)](https://www.typescriptlang.org/) <br/>
[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/john98nf/Eir-Appathon-NTUA/blob/master/LICENSE)
[![Open Source Love svg2](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)
## General
Eir is a simple Web Application, designed and implemented for the contest of [Appathon@NTUA](http://147.102.19.19/wordpress). This competition was organised by the teacher and PhD students of the ["Internet Applications"](http://ecourses.dbnet.ntua.gr/15372.html) course in the [School of Electrical & Computer Engineering of the National Technical University of Athens](https://www.ece.ntua.gr/gr). As far as its name is concerned, it has been inspired by Norse mythology and in more depth by the aforamentioned goddess or else valkyrie, associated with medical skill. Further knowledge for this subject can be obtained [here](https://en.wikipedia.org/wiki/Eir).

## Table of Contents
- [Utilities](#utilities)
- [Directories' Structure](#directories)
- [Technologies & Datasets](#technologies)
- [Installation Process](#installation)

<a name="utilities"/>

## Utilities
By processing all the available data, offered by the website https://clinicaltrials.gov/, web application Eir is able to present:
* The number of studies found for each condition.
* The amount of patients that have been enrolled for clinical studies,relevant to a certain desease (i.e. Sjogren's Syndrome), and participated in them (enrollment type: "Actual").
* The amount of anticipated patients that have been enrolled for clinical studies, relevant to a certain desease (enrollment type: "Anticipated").
* The average time duration (in days) that was required for the requitment of these volunteers, based upon the initial submition date and the date that each clinical study has been updated for the last time.
* A random clinical study relevant to the selected condition, a brief summary for it and the research center responsible.

<a name="directories"/>

## Directories' Structure

For the dictory management, it was decided to follow the structure mentioned below:

* The entiry front-end server-project, with its components, is located inside the [front-end](https://github.com/john98nf/Eir-Appathon-NTUA/tree/master/front-end) folder.
* The back-end service with the rest, entities and repository components can be found inside the [back-end](https://github.com/john98nf/Eir-Appathon-NTUA/tree/master/back-end) folder.
* The folder [Dumps](https://github.com/john98nf/Eir-Appathon-NTUA/tree/master/Dumps) has been created for storing datasets mentioned above (not uploaded in this repo), database dump-binary files (not upload in this repo) and all the appropriate scripts used in the process of database constraction.
* Inside the folder named [presentation](https://github.com/john98nf/Eir-Appathon-NTUA/tree/master/presentation), presentation slides and link to the relevant video were placed as requested by the supervisors.

<a name="technologies"/>

## Technologies & Datasets

* The specific dataset used in Eir can be obtained [here](https://clinicaltrials.gov/AllPublicXML.zip).
* [MongoDB](https://www.mongodb.com/) was used as a database management system.
* The back-end REST web service was written in [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html), while
[Spring Boot Framework](https://spring.io/projects/spring-boot) was also widely used. In more depth, libraries & products like [Spring Web Serices](https://spring.io/projects/spring-ws), [Spring Hateoas](https://spring.io/projects/spring-hateoas), [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) and others have been added.
* Front-end server was designed using HTML 5/CSS 3 with [Angular Framework](https://angular.io/) & [Typescript](https://www.typescriptlang.org/).
* [Maven Build Tool](https://maven.apache.org/).

<a name="installation"/>

## Installation

Developers interested in trying running this application on their personal machines are more than welcome to read [INSTALLATION.md](https://github.com/john98nf/Eir-Appathon-NTUA/tree/master/INSTALLATION.md) file for further information.
