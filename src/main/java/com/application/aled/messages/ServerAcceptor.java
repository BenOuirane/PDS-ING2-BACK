package com.application.aled.messages;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * This class receive message in xml format and it gives it to the XmlReader by the method xmlTranslate
 */
public class ServerAcceptor {

    static Logger logServerAcceptor = Logger.getLogger("com.application.aled.message.ServerAcceptor");
    public ServerAcceptor() throws IOException {
        final String logFilePath = "../logFile.txt";
        final File logFile = new File(logFilePath);
        fileWriter = new FileWriter(logFile);
    }

    public static FileWriter fileWriter;
    public static final int portListen = 5001;

    public void receiveMessage() {
        // Create server socket to receive messages
        ServerSocket socketServer = null;
        String str = null;
        String str2 = null;
        String str3 = null;

        try {
            socketServer = new ServerSocket(portListen);
        } catch(IOException e) {
            logServerAcceptor.severe("Impossible to create server socket : " + e);
        }

        // waiting a client connection
        Socket socketClient = null;
        try {
            socketClient = socketServer.accept();
        } catch(IOException e) {
            logServerAcceptor.severe("Erreur lors de l'attente d'une connexion : " + e);
        }

        // Associate input stream
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socketClient.getInputStream());
        } catch(IOException e) {
            logServerAcceptor.severe("Impossible to associate stream to the socket: " + e);
        }

        // We waiting and receive an message which coming from an object
            try {
                XmlController xmlReader = new XmlController();
                while (true) {
                    str = (String) ois.readObject();
                    logServerAcceptor.info("message received: " + str);
                    /**
                     * We transmit the xml string to the Xml reader to analyse and stock its information
                     **/
                    xmlReader.xmlTranslate(str);
                }
            } catch (IOException | ClassNotFoundException e) {
                logServerAcceptor.severe("Erreur lors de la lecture : " + e);
            }finally {
                try {
                    fileWriter.close();
                    ois.close();
                    socketClient.close();
                    socketServer.close();
                } catch(IOException e) {
                    logServerAcceptor.severe("Error during stream and socket closing : " + e);
                }
            }


    }

    public static void main(String[] args) throws IOException {
        ServerAcceptor serverAcceptor = new ServerAcceptor();
        serverAcceptor.receiveMessage();
    }


}

