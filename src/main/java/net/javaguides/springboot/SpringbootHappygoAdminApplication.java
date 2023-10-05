package net.javaguides.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//public class SpringbootHappygoAdminApplication implements CommandLineRunner {
public class SpringbootHappygoAdminApplication extends SpringBootServletInitializer {

	@Autowired
	private JdbcTemplate jdbcTemplate ;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootHappygoAdminApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM HG_MANAGER" ;
//		List<Test> mydata = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Test.class));
//		mydata.forEach(System.out :: println);
//		
//	}
	
	/**
	 * 打包
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	//注意这里要指向原先用main方法执行的Application启动类
	return builder.sources(SpringbootHappygoAdminApplication.class);
	}
}
