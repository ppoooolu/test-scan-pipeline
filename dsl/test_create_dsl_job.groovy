import javaposse.jobdsl.dsl.Job
import org.Fleets
import static dsl.CreateMulitibranchPipelineJob

Job collectParamsJob = new CreateMulitibranchPipelineJob().build(this)