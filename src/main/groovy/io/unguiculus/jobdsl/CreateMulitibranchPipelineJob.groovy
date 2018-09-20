package io.unguiculus.jobdsl

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

class CreateMulitibranchPipelineJob {
    String name ='test_111'
    String description ='1111'
    String stashProject = 'l4c'
    String stashRepo = 'jenkins-pipeline'
    String stashBranch = 'master'
    String scriptPath = 'jenkinsfile'

    Job build(DslFactory dslFactory) {
        Job job = dslFactory.multibranchPipelineJob(name) {
            it.description this.description
        }
        job.with {
            branchSources {
                git {
                    remote('https://github.com/jenkinsci/job-dsl-plugin.git')
                    credentialsId('github-ci')
                    includes('JENKINS-*')
                }
            }

//            factory {
//                workflowMultiBranchProjectFactory {
//                    scriptPath('my-location/Jenkinsfile')
//                }
//            }
        }

    }
}