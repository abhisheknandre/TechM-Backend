package com.TechM_VSM.VehicleServiceManagement.configuration;

import org.springframework.boot.autoconfigure.graphql.security.GraphQlWebFluxSecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfiguration {
}
