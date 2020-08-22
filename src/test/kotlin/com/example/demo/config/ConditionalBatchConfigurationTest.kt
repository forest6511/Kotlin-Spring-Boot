package com.example.demo.config

import com.example.demo.DemoApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest(classes = [DemoApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ConditionalBatchConfigurationTest @Autowired constructor(
        private val jobLauncherTestUtils: JobLauncherTestUtils
) {
    @Test
    fun launcherTest01() {
        val map = mutableMapOf("param1" to JobParameter("1"))
        val param: JobParameters = JobParameters(map)
        val jobExecution: JobExecution = jobLauncherTestUtils.launchJob(param)
        assertEquals("COMPLETED", jobExecution.exitStatus.exitCode)
    }

    @Test
    fun launcherTest02() {
        val map = mutableMapOf("param1" to JobParameter("2"))
        val param: JobParameters = JobParameters(map)
        val jobExecution: JobExecution = jobLauncherTestUtils.launchJob(param)
        assertEquals("FAILED", jobExecution.exitStatus.exitCode)
    }

    @Test
    fun launcherTest03() {
        val map = mutableMapOf("param1" to JobParameter("3"))
        val param: JobParameters = JobParameters(map)
        val jobExecution: JobExecution = jobLauncherTestUtils.launchJob(param)
        assertEquals("FAILED", jobExecution.exitStatus.exitCode)
    }

}
