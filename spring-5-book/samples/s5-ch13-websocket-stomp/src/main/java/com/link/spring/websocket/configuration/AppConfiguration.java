package com.link.spring.websocket.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * App Configuration.

 */
@Configuration
@ComponentScan(basePackages = {"com.link.spring"})
@Import({ MvcConfig.class, WebSocketMessageConfig.class })
public class AppConfiguration {

}
