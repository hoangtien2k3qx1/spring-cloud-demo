package com.hoangtien2k3.notificationservice.config

import org.springframework.context.annotation.Bean
import org.springframework.kafka.support.converter.JsonMessageConverter

class AppConfig {
    @Bean
    fun converter(): JsonMessageConverter = JsonMessageConverter()
}