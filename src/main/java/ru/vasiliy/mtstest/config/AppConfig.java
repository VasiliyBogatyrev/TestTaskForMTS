package ru.vasiliy.mtstest.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

@Configuration
@EnableWebMvc
@EnableJpaRepositories
@ComponentScan(basePackages = "ru.vasiliy.mtstest")
@ImportResource("classpath:/application-context.xml")
public class AppConfig {

}


