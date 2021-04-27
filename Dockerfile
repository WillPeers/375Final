FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
COPY 375Final /usr/src/375Final
WORKDIR /usr/src/375Final
RUN mvn package
