package com.application.aled.messages;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
public class WaitingTimeCheckerTest {

    /*private static Stream<Arguments> objectsData() {
        Message message = new Message();
        message.setDateTime(new Timestamp(System.currentTimeMillis()));
        Objects objects = new Objects();
        objects.setObjectType("LAMP");

        return Stream.of(arguments(message,objects)
            );

    }
*/
    @Test
    public void checkTimeTestLamp(/*Message message, Objects objects*/){
        Objects object = new Objects();
        object.setObjectType("LAMP");
        WaitingTimeChecker waitingTimeChecker = new WaitingTimeChecker();
        Assertions.assertTrue(waitingTimeChecker.checkTime(object));
        //Assertions.assertTrue(true);
    }

}
