# Eir-Appathon-NTUA

## General
Το Eir αποτελεί μία διαδικτυακή εφαρμογή που υλοποιήθηκε στα πλαίσια του [Appathon@NTUA](http://147.102.19.19/wordpress), ο οποίος πραγματοποιήθηκε κατά τη διάρκεια του μαθήματος ["Διαδίκτυο & Εφαρμογές"](http://ecourses.dbnet.ntua.gr/15372.html) της σχολής [Ηλεκτρολόγων Μηχανικών & Μηχανικών Υπολογιστών του Εθνικού Μετσόβιου Πολυτεχνείου](https://www.ece.ntua.gr/gr).Το όνομα πηγάζει από την Σκαδιναβική μυθολογία και συγκεκριμένα την ομώνυμη θεότητα - valkyrie που ήταν συνιφασμένη με την "θεραπευτική τέχνη" και τις εφαρμογές της ιατρικής. Περισσότερες εγκυκλοπαιδικές πληροφορίες μπορούν να βρεθούν [εδώ](https://en.wikipedia.org/wiki/Eir).

## Utilities
Αξιοποιώντας διαθέσιμα δεδομένα της ιστοσελίδας https://www.semanticscholar.org/cord19, η διαδικτυακή εφαρμογή Eir παρουσιάζει το σύνολο των ασθενών που συμμετέχουν σε κλινικές δοκιμές (enrollment – type: actual), οι οποίες αφορούν μια συγκεκριμένη ασθένεια (π.χ. Sjogren’s Syndrome). Παράλληλα, πραγματοποιείται υπολογισμός και παρουσίαση του μέσου χρόνου που χρειάστηκε για την εύρεση των ασθενών (aka στρατολόγηση), λαμβάνοντας υπόψη το πότε ξεκίνησε η κλινική μελέτη και πότε έγινε τελευταία φορά update. (Η προαναφερθείσα λειτουργία βασίζεται σε θέμα, που προτάθηκε από τους υπεύθυνους και διδάσκοντες του μαθήματος και συγκεκριμένα πρόκειται για αυτό με τη κωδική ονομασία CTGOV-01.)

## Technologies & Datasets**

* Τα δεδομένα που αξιοποιήθηκαν [εδώ](https://www.semanticscholar.org/cord19).
* [MongoDB](https://www.mongodb.com/) ως σύστημα διαχείρισης της Βάσης Δεδομένων (DBMS).
* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html), [Spring Boot Framework](https://spring.io/projects/spring-boot), [Restlet Framework](https://restlet.talend.com/) για τον back-end εξυπηρετητή.
* HTML 5/CSS 3 with [Angular Framework](https://angular.io/) & [Typescript](https://www.typescriptlang.org/) για τον front-end εξυπηρετητή.
* [Maven Build Tool](https://maven.apache.org/).

** Τυχόν μεταβολές σε εργαλεία, frameworks και γλώσσες προγραμματισμού που απαιτηθούν για την υλοποίηση του εγχειρήματος θα καταγραφούν στο συγκεκριμένο αρχείο.
