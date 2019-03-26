@Library('my-lib') pipelineLibrary

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('ls') {
            steps {
                script {
                    sh 'env'
                    echo 'test aaaaaa'
                    currentBuild.displayName = env.GIT_BRANCH
                }
            }
        }
    }
}
