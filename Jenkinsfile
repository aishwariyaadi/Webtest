pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Run Maven clean package command
                script {
                    sh 'mvn clean package'
                }
            }
        }
    }
}