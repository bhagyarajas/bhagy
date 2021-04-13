#Longest Common Substring API
This API calculates the longest common string in a list of strings.

##Requirements
For building and running the application you need:

 1.	JDK 1.8
 2. POSTMAN(Testing)
 
##LOCAL SETUP
 Add the following line to your environment variable to set the java home environment variable.
 1. export JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home'
 2. bash profile is located at ~/.bash_profile
 
 Note: java path could be different depends on the java installed directory of your  machine
 
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
