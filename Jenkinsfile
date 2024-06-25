// pipeline {
//     agent any
//     tools {
//         maven '3.9.6'
//     }
//
//     stages {
//         stage('Build') {
//             steps {
//                 // Run Maven clean package command
//                 script {
//                     sh 'mvn clean package'
//                 }
//             }
//         }
//     }
// }
pipeline {
    agent any
    tools {
          maven '3.9.6'
       }

    environment {
        // Set environment variables if needed
        CHROME_DRIVER_PATH = "/usr/local/bin/chromedriver"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git 'https://github.com/aishwariyaadi/Webtest.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run the tests using Maven
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish TestNG results
                junit 'target/surefire-reports/testng-results.xml'
            }
        }
    }
}
