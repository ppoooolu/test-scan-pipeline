@Library('my-lib') pipelineLibrary

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('ls') {
            steps {
                script {
                    sh 'env'
                    echo 'test master'
                    currentBuild.displayName = env.GIT_BRANCH
                }
            }
        }
    }
}
