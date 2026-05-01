pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        APP_NAME = "product-service"
        APP_PORT = "8081"
        IMAGE_NAME = "product-service"
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
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

    post {
        success {
            echo "✅ ${APP_NAME} deployed successfully!"
        }
        failure {
            echo "❌ Build failed. Check logs."
        }
    }
}