# germedica-ui-test-framework
germedica-ui-test-framework

UI framework has been created in selenide and testng Framework in integration with allure report and Report portal.

# command to execute the test cases.
mvn clean compile test 
-Dmaven.test.failure.ignore  
-Dselenide.browser=chrome 
-Dselenide.headless=false 
-Dproperty.file=prod 
-Dtestng.dtd.http=true 

# cross browser supported for testing
- https://selenide.org/javadoc/current/com/codeborne/selenide/Browsers.html

# Frequently Asked Questions
- https://selenide.org/faq.html

# help
xpath :
https://www.youtube.com/watch?v=3uktjWgKrtI

eg.
//dependency[(((groupId[text()='log4j']) and (artifactId[text()="log4j"])) or ((groupId[text()='org.apache.logging.log4j']) and (artifactId[text()='log4j-core' or text()='log4j-api']) and (version[not(matches(text(), "([2-9]+\.1[5-9]\.[0-9]+)"))] )))]
