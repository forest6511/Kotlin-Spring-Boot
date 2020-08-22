package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }
}
