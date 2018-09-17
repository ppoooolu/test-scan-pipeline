import javaposse.jobdsl.dsl.Job
//import static org.Fleets
import static main.groovy.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)