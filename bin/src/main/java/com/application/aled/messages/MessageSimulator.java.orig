package com.application.aled.messages;

import java.io.IOException;


public class MessageSimulator {

    public static final int portNumber = 5001;
    public void sendMessage() throws IOException, InterruptedException {
        String obj="<message>" +
                "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
                "        <effective_temperature>16</effective_temperature>" +
                "    <programmed_temperature>200</programmed_temperature>" +
                "</message>";
        String obj2="<message>" +
                "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
                "        <effective_temperature>100</effective_temperature>" +
                "    <programmed_temperature>400</programmed_temperature>" +
                "</message>";
        String obj3="<message>" +
                "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
                "        <effective_temperature>290</effective_temperature>" +
                "    <programmed_temperature>200</programmed_temperature>" +
                "</message>";

//uncomment to lauch the simulation

        XmlController xmlController = new XmlController();
        //xmlController.xmlTranslate(obj);
        Thread.sleep(2000);

        //xmlController.xmlTranslate(obj2);
        Thread.sleep(2000);

        //xmlController.xmlTranslate(obj3);




        System.out.println("message is sent");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MessageSimulator ms = new MessageSimulator();

        ms.sendMessage();
    }
}
