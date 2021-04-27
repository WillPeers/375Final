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
      post{
        always{
          junit 'target//surefire-reports/TEST-*.xml'
        }
      }
    }

    stage('Docker Build') {
      steps {
        script {
          image = docker.build registry
        }
      }
    }

    stage('Deploy') {
      steps {
        script {
          docker.withRegistry('', credentials) {
            image.push()
          }
        }
      }
    }
  }
  tools {
    maven 'Maven 3.6.3'
  }
  environment {
    registry = 'billpeers/ense_final'
    credentials = 'dockerhub_id'
    image = ''
  }
}