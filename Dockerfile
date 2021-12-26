FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# Add .jar under target from host into this image
ADD target/selenium-docker.jar 		selenium-docker.jar
ADD target/selenium-docker-tests.jar 		selenium-docker-tests.jar
ADD target/libs 							libs

# Add suite files 
ADD flights-module.xml		book-flight-module.xml
ADD search-module.xml 			search-module.xml


#Add healthcheck script
ADD healthcheck.sh					healthcheck.sh


#BROWSER
#HUB HOST
#MODULE
ENTRYPOINT sh healthcheck.sh