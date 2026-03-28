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
                bat 'cd UI && mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat '''
        cd UI
        CALL minikube docker-env --shell cmd > env.cmd
        CALL env.cmd
        docker build -t ui:v1 .
        '''
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat '''
                set KUBECONFIG=C:\\Users\\pc\\.kube\\config
                kubectl apply -f k8s/
                '''
            }
        }

        stage('Verify') {
            steps {
                bat 'set KUBECONFIG=C:\\Users\\pc\\.kube\\config && kubectl get pods'
                bat 'set KUBECONFIG=C:\\Users\\pc\\.kube\\config && kubectl get svc'
            }
        }
    }
}