
pipeline {
    agent any
    stages{
        stage('Generate jobs'){
            steps {
                jobDsl(
                        additionalClasspath: 'src/dsl',
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
