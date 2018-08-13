package kr.or.connect.mvcexam.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"kr.or.connect.mvcexam.dao"})
@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {
	@Bean
	public Map<String, List> gangMap() {
		Map<String, List> gangMap = new HashMap();
		return gangMap;
	}
}
