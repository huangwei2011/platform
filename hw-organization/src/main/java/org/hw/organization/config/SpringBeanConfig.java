package org.hw.organization.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.hw.organization.api","org.hw.organization.domain.service"})
public class SpringBeanConfig {

}
