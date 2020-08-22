package com.example.demo

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfigurationTest {
    @Bean
    fun jobLauncherTestUtils(): JobLauncherTestUtils {
        return JobLauncherTestUtils()
    }
}
