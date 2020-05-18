package com.application.aled;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.ComponentScan;
import com.application.aled.controller.AreaController;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class BackendApplication extends SpringBootServletInitializer {
	static final Logger logger = LogManager.getLogger(BackendApplication.class.getName());



	public static void main(String[] args) throws IOException {
		logger.info("com.application.aled.BackendApplication");

		SpringApplication.run(BackendApplication.class, args);

		logger.info("Application is initialized :)");
	}

}
