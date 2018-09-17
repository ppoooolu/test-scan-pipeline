import javaposse.jobdsl.dsl.Job
//import static org.Fleets
import main.groovy.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)