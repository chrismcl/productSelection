Minimum Requirements:
* Java 1.8
* Maven 3.2.1
* Note that this application uses Maven's embedded tomcat 7.0.47
* (if enabled) mysql 5.6

To run:
* From the root directory type: mvn clean tomcat7:run-war -Dmaven.tomcat.port=8082
* This will run on Port 8082.  If you omit the option it will run on port 8080

Webpage Manually tested on Firefox 50.1.0, Chrome 56.0.2924.87 and Safari 10.0.3 
But currently investigating how to use selenium. Not currently sure how compatible it will be with primefaces.
Another option is browserstack

Other Information:
* The test suite and main app use an in-memory database
* To use mysql instead comment out the embedded datasource
* uncomment the mysql datasource.  Change the user and password if needed.
* to create a new database: mysql -uroot -p < ./scripts/prod_sel.db
* when you run the app the TempDatabase.java file will auto fill with the defaults (this would be removed once in a real environment).








