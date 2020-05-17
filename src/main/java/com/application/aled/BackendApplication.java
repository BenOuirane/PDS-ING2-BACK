package com.application.aled;

<<<<<<< HEAD
<<<<<<< HEAD
import javafx.application.Application;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
import java.io.IOException;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.logging.Logger;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.ComponentScan;
<<<<<<< HEAD
<<<<<<< HEAD



//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
//@EnableSwagger2
public class BackendApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException {
		Logger logger = Logger.getLogger("com.application.aled.BackendApplication");
=======
import com.application.aled.controller.AreaController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@SpringBootApplication
=======
import com.application.aled.controller.AreaController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@SpringBootApplication
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
@EnableSwagger2
public class BackendApplication extends SpringBootServletInitializer {
	static final Logger logger = LogManager.getLogger(BackendApplication.class.getName());



	public static void main(String[] args) throws IOException {
		logger.info("com.application.aled.BackendApplication");
<<<<<<< HEAD
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
=======
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc

		SpringApplication.run(BackendApplication.class, args);

		logger.info("Application is initialized :)");
	}

}
