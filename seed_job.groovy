
pipeline {
    agent any
    stages{
        stage('Generate jobs'){
            steps {
                jobDsl(
                        additionalClasspath: 'src',
                        removedJobAction: 'DELETE',
                        removedViewAction: 'DELETE',
                        targets: 'dsl/*',
                        unstableOnDeprecation: true
                )
            }
        }
    }
}
