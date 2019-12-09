package com.application.aled.messages;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class MessageSimulator {

    public static final int portNumber = 5001;
    public void sendMessage(String obj) throws IOException {
        Socket socket;


        socket = new Socket(InetAddress.getLocalHost(), portNumber);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);

        oos.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Thread app = new Thread();
        MessageSimulator ms = new MessageSimulator();
        String obj="<message>" +
                "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
                "        <effective_temperature>100</effective_temperature>" +
                "    <programmed_temperature>200</programmed_temperature>" +
                "</message>";
        ms.sendMessage(obj);
    }
}
