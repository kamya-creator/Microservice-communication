package com.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    ModelMapper getmodelMapper() {
        return new ModelMapper();
    }
}
