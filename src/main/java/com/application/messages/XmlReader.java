package com.application.messages;

import com.application.aled.entity.Message;
import com.application.aled.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Properties;

@RestController
public class XmlReader {
    @Autowired
    private static MessageRepository messageRepository;
    /**
     * Just an example to test the xmlTranslate method
     */
    String xmlString = "<message>" +
            "    <mac_address>00-1E-33-1D-6A-79</mac_address>" +
            "        <effective_temperature>100</effective_temperature>" +
            "    <programmed_temperature>200</programmed_temperature>" +
            "</message>";

    /*
    This method must create an object message from a xml file in a first time.
    After that it save the message in the database
     */
    public static void xmlTranslate(String xmlString){

        /*
        JAXBContext allow to create an xml object from an existing class
         */
        JAXBContext jaxbContext;

        try
        {
            jaxbContext = JAXBContext.newInstance(Message.class);
            /*
            Unmarshaller permits java to read an xml string and create an object with it
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Message message = (Message) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

            /*
            We consider that send timestamp close to receive timestamp
             */
            Date date= new Date();
            long time = date.getTime();
            message.setDateTime(new Timestamp(time));
            System.out.println(message);

            /*
            We save the new message into table message
             */
            messageRepository.save(message);
        }
        catch (JAXBException e)
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
