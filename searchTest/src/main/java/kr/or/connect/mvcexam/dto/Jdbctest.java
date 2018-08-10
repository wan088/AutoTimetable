package kr.or.connect.mvcexam.dto;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.mvcexam.config.ApplicationConfig;
import kr.or.connect.mvcexam.dao.GangDao;

public class Jdbctest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GangDao gd = ac.getBean(GangDao.class);
		List<gang> list =gd.selectByName("BasicEAS");
		System.out.println(list);
	}

}
