package shixun.online.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("shixun.online.project.mapper")
public class ExaminationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaminationSystemApplication.class, args);
	}

}
