pipeline {
    agent any

    environment {
        AWS_REGION = 'us-west-2'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Backend') {
            steps {
                dir('backend') {
                    sh './gradlew build'
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('backend') {
                    sh './gradlew test'
                }
            }
        }

        stage('Terraform Init & Plan') {
            steps {
                dir('terraform') {
                    sh 'terraform init'
                    sh "terraform plan -var='region=${AWS_REGION}'"
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                input message: 'Apply Terraform changes?'
                dir('terraform') {
                    sh "terraform apply -auto-approve -var='region=${AWS_REGION}'"
                }
            }
        }
    }
}
