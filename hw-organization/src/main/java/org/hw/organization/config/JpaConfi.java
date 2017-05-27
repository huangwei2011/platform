package org.hw.organization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="org.hw.organization.domain.dao")
public class JpaConfi {

}
