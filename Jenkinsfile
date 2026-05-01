pipeline {
    agent any

    environment {
        APP_NAME = "product-service"
        APP_PORT = "8081"
        IMAGE_NAME = "product-service"
    }

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop ${APP_NAME} || true
                docker rm ${APP_NAME} || true
                docker run -d -p ${APP_PORT}:${APP_PORT} --name ${APP_NAME} ${IMAGE_NAME}:latest
                '''
            }
        }
    }
}