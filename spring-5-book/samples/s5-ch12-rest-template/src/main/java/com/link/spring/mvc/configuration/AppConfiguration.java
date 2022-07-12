package com.link.spring.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * App Configuration.

 */
@Configuration
@ComponentScan(basePackages = {"com.link.spring"})
@Import({ MvcConfiguration.class, RestConfiguration.class })
public class AppConfiguration {

}
