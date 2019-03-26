@Library('my-lib') pipelineLibrary

pipeline {
    agent any

    stages {
        stage('ls') {
            steps {
                script {
                    sh('ls')
                    echo env.BRANCH_NAME
                }
            }
        }
    }
}
