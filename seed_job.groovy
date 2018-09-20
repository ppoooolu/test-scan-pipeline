
pipeline {
    agent any
    stages{
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test_gradlew') {
            sh './gradlew test'
        }
        stage('Generate jobs'){
            steps {
                jobDsl(
                        additionalClasspath: 'src/main/groovy',
                        removedJobAction: 'DELETE',
                        removedViewAction: 'DELETE',
                        targets: 'dsl_jobs/jobs_test.groovy',
                        unstableOnDeprecation: true,
                        sandbox: true
                )
            }
        }
    }
}
