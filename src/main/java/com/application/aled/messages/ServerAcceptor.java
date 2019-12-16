package com.application.aled.messages;
import javax.sql.rowset.spi.XmlReader;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class receive message in xml format and it gives it to the XmlReader
 */
public class ServerAcceptor {

    public static final int portEcoute = 5001;

    public static void receiveMessage() {
        // Création de la socket serveur
        ServerSocket socketServeur = null;
        String str = null;
        try {
            socketServeur = new ServerSocket(portEcoute);
        } catch(IOException e) {
            System.err.println("Création de la socket impossible : " + e);
            System.exit(-1);
        }

        // waiting a client connection
        Socket socketClient = null;
        try {
            socketClient = socketServeur.accept();
        } catch(IOException e) {
            System.err.println("Erreur lors de l'attente d'une connexion : " + e);
            System.exit(-1);
        }

        // Associate input stream
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socketClient.getInputStream());

        } catch(IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }

        // We waiting and receive an message which coming from an object
            try {
                str = (String) ois.readObject();
                System.out.println("message received: " + str);

            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);
            }

            /**
             *
             * We transmit the xml string to the Xml reader to analyse and stock its information
             *
             **/
            XmlController xmlReader = new XmlController();
            xmlReader.xmlTranslate(str);


        // Fermeture des flux et des sockets
        try {
            ois.close();
            socketClient.close();
            socketServeur.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et des sockets : " + e);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        ServerAcceptor serverAcceptor = new ServerAcceptor();
        serverAcceptor.receiveMessage();
    }


}

