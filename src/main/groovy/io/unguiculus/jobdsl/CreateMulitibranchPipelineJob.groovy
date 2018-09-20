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
                    remote('https://github.com/ppoooolu/test-pipline.git')
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

                strategy {
                    defaultBranchPropertyStrategy {
                        props {
                            noTriggerBranchProperty()
                        }
                    }
                }
            }

//            factory {
//                workflowBranchProjectFactory {
//                    scriptPath('back/step2.groovy')
//                }
//            }

            configure {
                it / factory(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory') {
                    owner(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject', reference: '../..')
                    scriptPath("back/step2.groovy")
                }

                it / sources / 'data' / 'jenkins.branch.BranchSource' << {
                    // default strategy when sourcing from a branch
                    strategy(class: "jenkins.branch.NamedExceptionsBranchPropertyStrategy") {
                        defaultProperties(class: "java.util.Arrays\$ArrayList") {
                            a(class: "jenkins.branch.BranchProperty-array") {
                                // don't trigger builds
                                "jenkins.branch.NoTriggerBranchProperty"()
                            }
                        }
                    }
                }
            }
        }

    }
}
