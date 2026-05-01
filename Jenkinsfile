pipeline {
    agent any

    environment {
        APP_NAME = "product-service"
        APP_PORT = "8081"
        IMAGE_NAME = "product-service"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo-url.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker stop ${APP_NAME} || true
                docker rm ${APP_NAME} || true
                docker run -d -p ${APP_PORT}:${APP_PORT} --name ${APP_NAME} ${IMAGE_NAME}
                '''
            }
        }
    }
}