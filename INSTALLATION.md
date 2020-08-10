# INSTALLATION PROCESS

Following the steps mentioned below, anyone would be able to try and test the web platform in their one local machine.

## Prerequisites

* [MongoDB](https://docs.mongodb.com/manual/installation/). After running mongo server, with the following commands it is possible to connect to it and create a database named eir.
```
mongo
use eir # any other name is possible, but a change inside application.properties is required
exit
```
* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
* [Maven](https://maven.apache.org/install.html).
* [npm](https://www.npmjs.com/get-npm)
* [node.js](https://nodejs.org/en/)
* [typescript](https://www.npmjs.com/package/typescript)
* [@angular/cli](https://www.npmjs.com/package/@angular/cli/v/9.0.4)

## Database Creation

Everyone interested in creating this database has two proper ways of doing so.

### Option A: Download raw dataset and import it from scratch
Clone or download this project and navigate to its home folder. Keep in mind that the above process is extremely time consuming and if you're looking a more straight forward solution, you are advised to implement Option B.

```
cd /path/to/Eir-Appathon-NTUA/Dumps
wget https://clinicaltrials.gov/AllPublicXML.zip
unzip AllPublicXML.zip -d xml                       # Data are available in xml form, which is not supported by mongodb
export PROJECT_FOLDER="/path/to/Eir-Appathon-NTUA"
./xml2json_converter.sh
./import_json_data.sh
```
The first script uses [xmljson](https://pypi.org/project/xmljson/) python library for converting xml format to json format, following the [GData](http://wiki.open311.org/JSON_and_XML_Conversion/) convetion (as attributes are needed for this application).
The second script imports json files, created above into eir db under the clinical_studies collection. Also, using sed command, the same script converts '$t' string in each file (before importing into db) with 'value'.
The reason behind this dummy trick, is the fact that unfortunately mongodb doesn't support field names starting with '$' character yet.

### Option B: Importing database from binary dumps

In this case, you are advise to download binary dumps from this [link]() and place it inside `Dumps` folder. In addition, you'll have to export the tarball and import generated files into eir db:

```
cd /path/to/Eir-Appathon-NTUA/Dumps
mkdir back-up
tar -xvzf back-up.tar.gz -C Dumps/back-up
mongorestore -h localhost:27017 -d eir Dumps/back-up/
```

## Testing Application
After the steps mentioned above and the installation of all the aforamentioned tools, it is possible to run the two servers of this application and test it.

### Back-end server
For this step, maven wrapper will finish all the work for us by downloading all the needed dependencies for this project.
```
cd /path/to/Eir-Appathon-NTUA/back-end
./mvnw spring-boot:run
```
After this, tomcat server will start listening for queries in localhost:8080. 
WARNING: It is a necessity to run mongodb server before this step, or else an exception will be raised and maven will warn you for it.

### Front-end server
Starting front-end service is straight forward and consists of these steps:

```
cd /path/to/Eir-Appathon-NTUA/front-end
npm install                               # Necessary only the first time you'll try to run it
ng serve
```
Now you can explore Eir Web App and its fuctionalities at localhost:4200/eir.
