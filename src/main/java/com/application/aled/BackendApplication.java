package com.application.aled;

import com.application.aled.messages.MessageSimulator;
import com.application.aled.messages.ServerAcceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/*
 * SpringBootApplication that will be launched
 */
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws IOException {
		/*TODO launch both parts
		ServerAcceptor.receiveMessage();
		MessageSimulator ms = new MessageSimulator();
		String obj="<message>" +
				"    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
				"        <effective_temperature>100</effective_temperature>" +
				"    <programmed_temperature>200</programmed_temperature>" +
				"</message>";
		try {
			ms.sendMessage(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("done");
		*/


		/**
		 * This line start the application for users
		 */
		SpringApplication.run(BackendApplication.class, args);

	}
}
