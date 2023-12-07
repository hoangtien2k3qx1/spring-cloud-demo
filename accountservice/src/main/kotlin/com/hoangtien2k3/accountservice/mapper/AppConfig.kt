package com.hoangtien2k3.accountservice.mapper

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.modelmapper.config.Configuration.AccessLevel;

@Configuration
class AppConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper().apply {
            configuration
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT)
        }
    }
}
