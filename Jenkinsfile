pipeline {
    agent any
    tools {
        maven 'Maven-3.9.12'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        
        // NEW STAGE FOR EXERCISE 14
        stage('SonarQube Analysis') {
            steps {
                // 'My Sonar Server' must match the name in Jenkins System Config
                withSonarQubeEnv('My Sonar Server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Build') {
            steps { sh 'mvn clean package -DskipTests' }
        }
        stage('Test') {
            steps { sh 'mvn test' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
    }
}
