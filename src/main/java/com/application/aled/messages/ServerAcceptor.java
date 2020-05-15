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
   public ServerAcceptor() throws IOException {
       final String chemin = "src/main/resources/logFile.txt";
      final File fichier = new File(chemin);
     writer = new FileWriter(fichier);
   }

   public static FileWriter writer;
  public static final int portEcoute = 5001;

     public void receiveMessage() {
        // Création de la socket serveur
        ServerSocket socketServeur = null;
        String str = null;
        String str2 = null;
       String str3 = null;

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

       //  We waiting and receive an message which coming from an object
            try {
                str = (String) ois.readObject();
              str2 = (String) ois.readObject();
             str3 = (String) ois.readObject();

           System.out.println("message received: " + str);



            /**
             *
             * We transmit the xml string to the Xml reader to analyse and stock its information
             *
             **/



        XmlController xmlReader = new XmlController();
        xmlReader.xmlTranslate(str);
         xmlReader.xmlTranslate(str2);
         xmlReader.xmlTranslate(str3);
           writer.close();
          } catch (IOException | ClassNotFoundException e) {
              System.err.println("Erreur lors de la lecture : " + e);
              System.exit(-1);
          }

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

    public static void main(String[] args) throws IOException {
        ServerAcceptor serverAcceptor = new ServerAcceptor();
     serverAcceptor.receiveMessage();
    }


 }

