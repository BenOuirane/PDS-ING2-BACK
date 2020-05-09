package com.application.aled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@SpringBootApplication

//@EnableSwagger2
public class BackendApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException {
		Logger logger = Logger.getLogger("com.application.aled.BackendApplication");

		SpringApplication.run(BackendApplication.class, args);

		logger.info("Application is initialized :)");
	}

}
