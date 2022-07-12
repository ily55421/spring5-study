package com.link.spring.mvc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configuration.

 */
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
}
