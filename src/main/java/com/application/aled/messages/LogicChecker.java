package com.application.aled.messages;

import com.application.aled.entity.Message;

import java.sql.*;

public class LogicChecker {
    public static boolean check(Message message) throws SQLException {
        PostgreSQLJDBC jdbcc = new PostgreSQLJDBC();
        Statement statment = jdbcc.connection.createStatement();
        ResultSet rs = statment.executeQuery("SELECT * FROM MESSAGES WHERE mac_address = '"+ message.getMac_address() +"'");
        rs.next();
        int effective_temperature= rs.getInt("effective_temperature");
        int programmed_temperature= rs.getInt("programmed_temperature");
        Timestamp dateTime = rs.getTimestamp("date_Time");
        if(message.getEffective_temperature()>300||message.getEffective_temperature()<15){
            System.out.println("Effective_temperature is too high or too low");
            return false;
        }

        if(message.getProgrammed_temperature()>290||message.getProgrammed_temperature()<15){
            System.out.println("Programmed_temperature is too high or too low");
            return false;
        }

        long messageLongDateTime = message.getDateTime().getTime();
        long dataLongDatetime = dateTime.getTime();
        long timeDifference = messageLongDateTime-dataLongDatetime;
        int temperatureDifference = message.getEffective_temperature()-rs.getInt("effective_temperature");
        System.out.println("Time de difference = "+ timeDifference);
        System.out.println("Temperature difference = "+ temperatureDifference);
        if(temperatureDifference/(timeDifference/360000)>1200) {
            System.out.println("temperature grow too quickly");
            return false;
        }
        statment.close();
        return true;
    }
}
