package com.application.aled.messages;

import com.application.aled.entity.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LogicChecker {
    public static boolean check(Message message) throws SQLException {
        /*
        Create a log file
         */
        final String chemin = "src/main/resources/logFile.txt";
        final File fichier = new File(chemin);
        final FileWriter writer;
        try {
            writer = new FileWriter(fichier);
            writer.write("we analyse the oven " + message.getMac_address() + "\n");


            /**
             * create a jdbc connection
             **/
            PostgreSQLJDBC jdbcc = new PostgreSQLJDBC();
            Statement statment = jdbcc.connection.createStatement();
            /**
             * Get all messages sended by this object
             **/
            ResultSet rs = statment.executeQuery("SELECT * FROM MESSAGES WHERE mac_address = '" + message.getMac_address() + "'");
            rs.next();
            int effective_temperature = rs.getInt("effective_temperature");
            int programmed_temperature = rs.getInt("programmed_temperature");
            Timestamp dateTime = rs.getTimestamp("date_Time");
            if (message.getEffective_temperature() > 300 || message.getEffective_temperature() < 15) {
                System.out.println("Effective_temperature is too high or too low");
                writer.write("The effective temperature is suspicious\n");
                writer.close();
                return false;
            }

            if (message.getProgrammed_temperature() > 290 || message.getProgrammed_temperature() < 15) {
                System.out.println("Programmed_temperature is too high or too low");
                writer.write("The programmed temperature is suspicious\n");
                writer.close();
                return false;
            }

            long messageLongDateTime = message.getDateTime().getTime();
            long dataLongDatetime = dateTime.getTime();
            long timeDifference = messageLongDateTime - dataLongDatetime;
            int temperatureDifference = message.getEffective_temperature() - rs.getInt("effective_temperature");
            System.out.println("Time de difference = " + timeDifference);
            System.out.println("Temperature difference = " + temperatureDifference);
            if (temperatureDifference / (timeDifference / 360000) > 1200) {
                System.out.println("temperature grow too quickly");
                writer.write("The grow of temperature is suspicious\n");
                writer.close();
                return false;
            }
            statment.close();
            writer.write("The programmed temperature is okey ("+ message.getEffective_temperature()+") \n");
            writer.write("The effective temperature is okey ("+ message.getEffective_temperature()+" °C)\n");
            writer.write("The grow of temperature is okey\n");
            writer.write("This oven is working, the message is saved\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Impossible to create file");
            e.printStackTrace();

        }
        return true;
    }
}
