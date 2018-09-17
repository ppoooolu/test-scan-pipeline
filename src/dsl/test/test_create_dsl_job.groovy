package dsl.test

import javaposse.jobdsl.dsl.Job
import dsl.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)