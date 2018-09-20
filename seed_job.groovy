
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
                        additionalClasspath: 'src/main/groovy',
                        removedJobAction: 'DELETE',
                        removedViewAction: 'DELETE',
                        targets: 'dsl_jobs/*',
                        unstableOnDeprecation: true,
//                        sandbox: true
                )
            }
        }
    }
}
