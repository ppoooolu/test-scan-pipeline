import javaposse.jobdsl.dsl.Job
//import static org.Fleets
import dsl.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)