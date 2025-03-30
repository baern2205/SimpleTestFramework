pipeline {
    agent any

    environment {
        BROWSER = "${params.BROWSER ?: 'chrome'}"
        CUCUMBER_TAG = "${params.CUCUMBER_TAG ?: '@SmokeTest'}"
    }

    parameters {
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Браузер для тестів')
        string(name: 'CUCUMBER_TAG', defaultValue: '@SmokeTest', description: 'Tag для запуску тестів')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh "./gradlew clean build"
        }
    }
        stage('Test Suite') {
            steps {
                sh "./gradlew smokeSuite -Pbrowser=${env.BROWSER} -Pcucumber.filter.tags='${env.CUCUMBER_TAG}'"
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/cucumber-report.html', allowEmptyArchive: true
            junit '**/target/test-results/*.xml'
        }
    }
}