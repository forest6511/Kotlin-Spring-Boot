package com.example.demo.config

import org.slf4j.LoggerFactory
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.lang.RuntimeException


/**
 * https://github.com/muumin/spring-boot-batch-sample
 */
@Component
@Configuration
@EnableBatchProcessing
class ConditionalBatchConfiguration {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    @Throws(Exception::class)
    fun condJob(jobs: JobBuilderFactory, conditionalStep1: Step): Job {
        return jobs["condJob"]
                .incrementer(RunIdIncrementer())
                .flow(conditionalStep1)
                .end()
                .build()
    }

    @Bean
    fun condStep1(steps: StepBuilderFactory): Step {
        return steps["condStep1"]
                .tasklet { contribution: StepContribution, chunkContext: ChunkContext ->
                    logger.info("START STEP ${chunkContext.stepContext.jobParameters["param1"]}")
                    val param1 = chunkContext.stepContext.jobParameters["param1"]
                    if (param1 is String) {
                        when (param1) {
                            "1" -> contribution.exitStatus = ExitStatus.COMPLETED
                            "2" -> contribution.exitStatus = ExitStatus.FAILED
                        }
                    }
                    if(param1 == "3"){
                        throw RuntimeException("ON PURPOSE")
                    }
                    RepeatStatus.FINISHED
                }.build()
    }
}
