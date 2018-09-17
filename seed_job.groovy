
pipeline {
    agent any
    stages{
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Generate jobs'){
            steps {
                jobDsl(
                        additionalClasspath: 'src',
                        removedJobAction: 'DELETE',
                        removedViewAction: 'DELETE',
                        targets: 'dsl/*',
                        unstableOnDeprecation: true,
                        sandbox: true
                )
            }
        }
    }
}
