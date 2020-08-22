package com.example.demo

import com.example.demo.config.DataSourceConfiguration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest(classes = [DemoApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DemoApplicationTests @Autowired constructor(
        private val ds: DataSourceConfiguration
) {

    @Test
    @DisplayName("SYSIBMが使用できるかテスト")
    fun db2DialectTest() {

        val sql = """
			SELECT
			    *
			FROM
			    SYSIBM.TABLES
			WHERE
			    TABLE_SCHEMA = 'DB2INST1'
			ORDER BY TABLE_NAME
		""".trimIndent()

        val con = ds.dataSource().connection
        con.prepareStatement(sql).use { ps ->
            ps.executeQuery().use { rs ->
                val list = arrayListOf<String>()
                while (rs.next()) {
                    // Get Table Name
                    list.add(rs.getObject(3).toString())
                }

                list.sort()
                assertEquals("BATCH_JOB_EXECUTION", list[0])
                //assertEquals("STORES", list[1])
                //assertEquals("flyway_schema_history", list[2])
            }
        }
    }

}
