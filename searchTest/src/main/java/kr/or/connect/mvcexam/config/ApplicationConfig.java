package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"kr.or.connect.mvcexam.dao"})
@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {

}
