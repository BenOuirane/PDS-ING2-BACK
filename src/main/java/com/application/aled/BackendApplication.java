package com.application.aled;


import javafx.application.Application;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.io.IOException;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.logging.Logger;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;


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
