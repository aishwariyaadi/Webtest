pipeline {
agent any


    tools {
        Maven '3.9.6'
    }

stages {


stage('Build') {

steps {

// Run Maven clean package command

sh 'mvn clean package'

}

}

}

}