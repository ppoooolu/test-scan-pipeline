@Library('my-lib') pipelineLibrary

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('ls') {
            steps {
                script {
                    sh 'env'
                    currentBuild.displayName = env.GIT_BRANCH
                }
            }
        }
    }
}
