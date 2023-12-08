package com.hoangtien2k3.accountservicekafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean

class AppConfig {

    @Bean
    fun notification(): NewTopic {
        // topic name, partition numbers, replication numbers
        return NewTopic("notification", 1, 1)
    }

    @Bean
    fun statistic(): NewTopic {
        // topic name, partition numbers, replication numbers
        return NewTopic("statistic", 1, 1)
    }

}