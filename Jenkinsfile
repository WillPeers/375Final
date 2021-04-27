pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn compile -f pom.xml'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test -f pom.xml'
      }
    }

  }
  tools {
    maven 'Maven 3.6.3'
  }
  environment {
    registry = 'billpeers/ense375-groupe'
    credentials = 'dockerhub_id'
    image = ''
  }
}