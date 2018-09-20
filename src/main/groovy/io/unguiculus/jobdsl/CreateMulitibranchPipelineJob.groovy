package io.unguiculus.jobdsl

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.jobs.MultibranchWorkflowJob

class CreateMulitibranchPipelineJob {
    String name ='test_111'
    String description ='1111'
    String stashProject = 'l4c'
    String stashRepo = 'jenkins-pipeline'
    String stashBranch = 'master'
    String scriptPath = 'jenkinsfile'

    MultibranchWorkflowJob build(DslFactory dslFactory) {
        MultibranchWorkflowJob job = dslFactory.multibranchPipelineJob(name) {
            it.description this.description
        }
        job.with {
            branchSources {
                git {
                    remote('https://github.com/ppoooolu/test-pipeline.git')
//                    credentialsId('github-ci')
//                    includes('JENKINS-*')
//                    traits {
//                        submoduleOptionTrait {
//                            extension {
//                                disableSubmodules(false)
//                                recursiveSubmodules(true)
//                                trackingSubmodules(false)
//                                reference(null)
//                                timeout(null)
//                                parentCredentials(true)
//                            }
//                        }
//
//                        cloneOptionTrait {
//                            extension {
//                                shallow(false)
//                                noTags(false)
//                                reference(null)
//                                depth(0)
//                                honorRefspec(false)
//                                timeout(10)
//                            }
//                        }
//                    }
                }
            }

            factory {
                workflowBranchProjectFactory {
                    scriptPath('back/step2.groovy')
                }
            }
        }

    }
}
