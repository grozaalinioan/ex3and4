# Java Selenium testing project

This is a Java Selenium framework using Page Objects Model for doing web automation testing
## Running tests on browser
The tests are run on Chrome by default.

### Prerequisites

This example requires the following softwares to run.
  * [Java](https://www.oracle.com/technetwork/java/javase/downloads/index.html) or openJDK
  * [Maven](https://maven.apache.org/download.cgi)
  * [Chrome driver](https://chromedriver.chromium.org/)
  * Chrome browser

### Setting up the project

* Clone git folder
* Download and install items from prerequisites list
* Create maven project in IDE (IntelliJ IDEA, Eclipse etc.) 
* Default location for chrome driver is "c:\\Selenium\\chromedriver\\chromedriver.exe"
* To use default settings, create this folder "c:\\Selenium\\chromedriver\\" and copy the "chromedriver.exe" file
* If you want to use another location for chrome driver, change the path in file "driverPath.txt" with your chrome driver path
* File "driverPath.txt" is located inside resources folder ("\src\main\resources\")

## How to run tests

Tests are placed inside the folder "\src\test\java\":

* TestEx3Ghost class -> searchBlog() : solution for exercise 3 on page "https://ghost.org/"
* TestEx4Way2Automation class -> validateShownDate() : solution for exercise 4 on page "http://way2automation.com/way2auto_jquery/index.php""

Ways to run tests:
* by running the methods having "@Test" annotation: "searchBlog()" and "validateShownDate()"
or
* by running the classes "TestEx3Ghost" and "TestEx4Way2Automation"
