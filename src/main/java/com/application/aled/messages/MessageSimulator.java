package com.application.aled.messages;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class MessageSimulator {

    public static final int portNumber = 5001;
    public void sendMessage() throws IOException, InterruptedException {
        Socket socket;
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

        socket = new Socket(InetAddress.getLocalHost(), portNumber);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        Thread.sleep(2000);
        oos.writeObject(obj2);
        Thread.sleep(2000);
        oos.writeObject(obj3);


        oos.close();
        socket.close();
        System.out.println("message is sent");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MessageSimulator ms = new MessageSimulator();

        ms.sendMessage();
    }
}
