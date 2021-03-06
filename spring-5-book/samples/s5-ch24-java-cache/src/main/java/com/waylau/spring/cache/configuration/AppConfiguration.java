package com.link.spring.cache.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * App Configuration.
 * 
 * @since 1.0.0 2018年3月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
@ComponentScan(basePackages = { "com.waylau.spring" })  
@Import({ MvcConfiguration.class, RestConfiguration.class, CacheConfiguration.class })
public class AppConfiguration {

}
