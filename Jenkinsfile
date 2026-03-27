pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/SandeepSuper/Ui.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'cd UI && mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'cd UI && docker build -t UI:v1 .'
            }
        }

        stage('Load Image to Minikube') {
            steps {
                sh 'minikube image load UI:v1'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }

        stage('Verify') {
            steps {
                sh 'kubectl get pods'
                sh 'kubectl get svc'
            }
        }
    }
}