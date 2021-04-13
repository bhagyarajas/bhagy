#Longest Common Substring API
This API calculates the longest common string in a list of strings.

##Requirements
For building and running the application you need:

 1.	JDK 1.8
 2.	Maven
 3. POSTMAN(Testing)
 
##LOCAL SETUP
 Add the following line to your environment variable to set the java home environment variable.
 1. export JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home'
 2. export M2_HOME=/usr/local/apache-maven/apache-maven-3.3.1
 3. export M2=$M2_HOME/bin
 4. bash profile is located at ~/.bash_profile
 
 Note: java and maven path could be different depends on the java/maven installed directory of your  machine.
       Please refer the below link for more details.
       https://maven.apache.org/install.html
       
##BUILD THE APPLICATION
 1. open terminal, navigate to the project root folder /lcs-api and run the command mvn clean install.
 
##START THE APPLICATION
 1. Copy the jar file "lcs-api-1.0.0-SNAPSHOT.jar" to a local folder.
 2. Open the terminal and navigate to the folder where your jar file is copied and execute the command 
    java -jar lcs-api-1.0.0-SNAPSHOT.jar
 3. By default application will be  started in the port 8080.
 
##TEST THE API
###REQUEST
 1. Open the POSTMAN and import the below curl command as a raw text.
 
  curl --location --request POST 'http://localhost:8080/lcs' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "setOfStrings": [
  {"value": "comcast"},
  {"value": "comcastic"},
  {"value": "broadcaster"}
  ]
  }'

###RESPONSE
 {
    "lcs": [
        {
            "value": "cast"
        }
    ]
 }
 # bhagy
