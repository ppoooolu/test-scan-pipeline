
pipeline {
    agent any
    stages{
        stage('Generate jobs'){
            jobDsl(
                    additionalClasspath: 'src',
                    removedJobAction: 'DELETE',
                    removedViewAction: 'DELETE',
                    targets: 'dls/*',
                    unstableOnDeprecation: true)
        }
    }
}
