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
        // This must match the Name 'My Sonar Server' from your screenshot
        withSonarQubeEnv('My Sonar Server') {
            sh 'mvn sonar:sonar'
        }
    }
}
        stage("Quality Gate") {
    steps {
        timeout(time: 1, unit: 'MINUTES') {
            // Jenkins will wait here for SonarQube's Pass/Fail result
            waitForQualityGate abortPipeline: true
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
