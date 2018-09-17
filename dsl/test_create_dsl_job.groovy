import javaposse.jobdsl.dsl.Job
import static dsl.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)