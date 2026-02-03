pipeline {
    agent any

    tools {
        // Use the exact name of the Maven tool you configured in Global Tool Configuration
        maven 'Maven-3.9.12'
    }

    stages {
        stage('Checkout') {
            steps {
                // This pulls your code from GitHub
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Runs Maven build and packages the JAR
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Runs JUnit tests (Quality Gate)
                sh 'mvn test'
            }
            post {
                always {
                    // Record test results regardless of pass/fail
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Archive') {
            steps {
                // Saves the JAR file as a build artifact
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }
}
