package com.application.aled.messages;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.repository.history.LampHistoryRepository;
import com.application.aled.service.history.LampHistoryService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @Mock
    LampHistoryService lampHistoryService;


    public void checkTimeTestLamp(/*Message message, Objects objects*/){
        Objects object = new Objects();
        object.setObjectType("LAMP");
        WaitingTimeChecker waitingTimeChecker = new WaitingTimeChecker();
        LampHistory lampTest = new LampHistory("COLOR", "RED", new Timestamp(System.currentTimeMillis()),object);
        List<LampHistory> lampHistoryList = new ArrayList<LampHistory>();
        lampHistoryList.add(lampTest);
        Mockito.when(lampHistoryService.getLampHistoryByObjectsId(object.getId())).thenReturn(lampHistoryList);
        Assertions.assertTrue(waitingTimeChecker.checkTime(object));
        //Assertions.assertTrue(true);
    }

    public void checkTimeTestLampNotRelevantDate(){
        Objects object = new Objects();
        object.setObjectType("LAMP");
        WaitingTimeChecker waitingTimeChecker = new WaitingTimeChecker();
        Date dateNotRelevant = new Date();
        int hour =dateNotRelevant.getHours()-1;
        dateNotRelevant.setHours(hour);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LampHistory lampTest = new LampHistory("COLOR", "RED", timestamp,object);
        List<LampHistory> lampHistoryList = new ArrayList<LampHistory>();
        lampHistoryList.add(lampTest);
        Mockito.when(lampHistoryService.getLampHistoryByObjectsId(object.getId())).thenReturn(lampHistoryList);
        Assertions.assertFalse(waitingTimeChecker.checkTime(object));
        //Assertions.assertTrue(true);
    }
}
