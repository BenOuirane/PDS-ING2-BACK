package com.application.aled;

import com.application.aled.messages.MessageSimulator;
import com.application.aled.messages.ServerAcceptor;
import com.application.aled.messages.WaitingTimeChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*
 * SpringBootApplication that will be launched
 */
@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer/* implements CommandLineRunner */{


	public static void main(String[] args) throws IOException {

		SpringApplication.run(BackendApplication.class, args);

		System.out.println("Application is running :)");

	}
	
}
