package com.application.aled.configuration;

import com.application.aled.messages.MessageSimulator;
import com.application.aled.messages.ServerAcceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Simulation {

    @PostConstruct
    @Transactional
    public void init() throws IOException {
        System.err.println("Simulation is running");
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
        System.out.println("Message sent to the server");
        t.start();
        t2.start();
        System.err.println("done");
    }
}
