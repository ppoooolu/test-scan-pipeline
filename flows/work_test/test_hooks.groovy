@Library('my-lib') pipelineLibrary

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('ls') {
            steps {
                script {
//                    sh 'ggggg'
                    currentBuild.displayName = env.GIT_BRANCH
                }
            }
        }
    }
}
