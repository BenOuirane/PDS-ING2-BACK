package com.application.aled.messages;

import com.application.aled.entity.Message;
import com.application.aled.repository.MessageRepository;
import com.application.aled.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.sql.Timestamp;

 @RestController
 @CrossOrigin(origins = "*")
 public class XmlController {

    @Autowired(required = true)
  MessageRepository messageRepository;
    /**
     * Just an example to test the xmlTranslate method
     */

  @Autowired
 MessageServiceImpl messageService;

   String xmlString = "<message>" +
         "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
         "        <effective_temperature>100</effective_temperature>" +
         "    <programmed_temperature>200</programmed_temperature>" +
       "</message>";

    /*
    This method must create an object message from a xml file in a first time.
    After that it save the message in the database
     */
  public void xmlTranslate(String xmlString){

        /*
        JAXBContext permits creation of a xml object from an existing class
         */
      JAXBContext jaxbContext;

       try
      {
         jaxbContext = JAXBContext.newInstance(Message.class);
            /*
            Unmarshaller read an xml string and create an object with the method unmarshal
             */
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Message message = (Message) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

            /*
            We consider that send timestamp close to receive timestamp
             */
          Date date= new Date();
           long time = date.getTime();
         message.setDateTime(new Timestamp(time));
         System.out.println("message = "+ message);

            /*
            We save the new message into table message
             */

            /**
             *
             * Analyse the logic of the message
             **/
      boolean isLogic = LogicChecker.check(message);
       if(!isLogic){
            System.out.println("there is an logic error");
           Statement sta = PostgreSQLJDBC.connection.createStatement();
         sta.executeUpdate("INSERT INTO public.failure("
                       +"begin_date, mac_address, message)"
                 +"VALUES ('"+message.getDateTime()+"','"+message.getMac_address()+"' ,'the message is not logic')");
              return;


           }



            //TODO make a better insert

            /**
             * insert the message into the database
             */


          Statement sta = PostgreSQLJDBC.connection.createStatement();
        sta.executeUpdate("INSERT INTO public.messages("
                 +"date_time, effective_temperature, mac_address, programmed_temperature)"
               +"VALUES ('"+message.getDateTime()+"',"+message.getEffective_temperature()+",'"+message.getMac_address()+"' ,"+message.getProgrammed_temperature()+")");

          messageRepository.save(message);
   }
       catch (JAXBException | SQLException e)
       {
        e.printStackTrace();
     }
   }

    /*
    test for the method
     */
    /**
    public static void main(String[] args) {
        MessageRepository messageRepository;
        String xmlString = "<message>" +
                "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
                "        <effective_temperature>100</effective_temperature>" +
                "    <programmed_temperature>200</programmed_temperature>" +
                "</message>";
        XmlReader x = new XmlReader();
        x.xmlTranslate(xmlString);

    }
     **/
 }

