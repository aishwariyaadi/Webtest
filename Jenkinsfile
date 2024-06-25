pipeline {
    agent any
    tools {
        maven '3.9.6'
    }
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