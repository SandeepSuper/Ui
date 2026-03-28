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
        docker build -t ui:v2 .
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

/*
pipeline {
    agent any

    environment {
        KUBECONFIG = 'C:\\Users\\pc\\.kube\\config'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t ui:v2 .'
            }
        }

        stage('Load Image to Minikube') {
            steps {
                bat 'minikube image load ui:v2'
            }
        }

        stage('Deploy Blue Version') {
            steps {
                bat 'kubectl apply -f k8s/deployment-blue.yml'
            }
        }

        stage('Wait for Pods') {
            steps {
                bat 'kubectl rollout status deployment/ui-blue'
            }
        }

        stage('Switch Traffic to Blue') {
            steps {
                bat 'kubectl patch svc ui -p "{\\"spec\\":{\\"selector\\":{\\"app\\":\\"ui\\",\\"version\\":\\"blue\\"}}}"'
            }
        }

        stage('Verify') {
            steps {
                bat 'kubectl get pods'
                bat 'kubectl get svc'
            }
        }
    }
} */
