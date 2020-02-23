package com.application.aled.configuration;

import com.application.aled.messages.MessageSimulator;
import com.application.aled.messages.ServerAcceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class Simulation {

    @PostConstruct
    @Transactional
    public void init() throws IOException {
        Logger logger = Logger.getLogger("com.application.aled.simulation");

        logger.info("Simulation is running");

        ServerAcceptor serverAcceptor = new ServerAcceptor();
        MessageSimulator ms = new MessageSimulator();
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    ms.sendMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                serverAcceptor.receiveMessage();
            }
        };
        logger.info("Message is sent to the server");
        t.start();
        //t2.start();
        logger.info("Done");
    }
}
