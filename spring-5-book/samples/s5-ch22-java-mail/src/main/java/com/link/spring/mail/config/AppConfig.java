package com.link.spring.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * App Configuration.

 */
@Configuration
@ComponentScan(basePackages = { "com.waylau.spring" })  
public class AppConfig {
	/**
	 * 配置邮件发送器
	 * @return
	 */
    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(25);//默认端口，标准的SMTP端口
        mailSender.setUsername("waylau521@163.com");//用户名
        mailSender.setPassword("password");//密码
        return mailSender;
    }

}
