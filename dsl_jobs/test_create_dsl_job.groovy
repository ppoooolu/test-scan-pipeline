import javaposse.jobdsl.dsl.Job
//import static org.Fleets
import learnsaas.dsl.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)