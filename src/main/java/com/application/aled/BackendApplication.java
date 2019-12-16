package com.application.aled;

import com.application.aled.messages.MessageSimulator;
import com.application.aled.messages.ServerAcceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*
 * SpringBootApplication that will be launched
 */
@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(BackendApplication.class, args);

		System.out.println("Application is running :)");

	}

}
