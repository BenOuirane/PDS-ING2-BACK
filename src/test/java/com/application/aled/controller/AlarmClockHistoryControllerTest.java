package com.application.aled.controller;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.messages.history.ObjectHistoryVerification;
import com.application.aled.service.history.AlarmClockHistoryServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.application.aled.controller.history.AlarmClockHistoryController; */

/**
 * Not working !!
 *
 * Exception on AlarmClockHistoryServiceImpl : unable to autowire AlarmClockHistoryRepository
 * Spend a few hours trying to resolve the problem, didn't succeed
 * Didn't keep the test made for the others 'HistoryControllers'
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(AlarmClockHistoryController.class)
public class AlarmClockHistoryControllerTest {

    //@Autowired
    private MockMvc mockMvc;

    //@Mock
    private AlarmClockHistoryServiceImpl service;

    ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();

    //@Test
    public void getHistoriesTest() throws Exception {
        Timestamp now = new Timestamp(new Date().getTime());

        Objects object = new Objects();
        object.setId(1);

        List<AlarmClockHistory> alarmClocks =  new ArrayList<AlarmClockHistory>();

        alarmClocks.add(new AlarmClockHistory("dataTest", "columnTest", now, object));

        String parameters = "{\"id\": \""+ object.getId() + "\"]}";

        given(service.getAlarmClockHistoryByObjectsId(object.getId())).willReturn(alarmClocks);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/history/alarmClock")
                .content(parameters)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].data").value("dataTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].columnData").value("columnTest")
                );

    }

    //@Test
    public void getAlarmsHistoryTest() throws Exception {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        Timestamp messageTimestamp = new Timestamp(end.getTime()-7*24*60*60*1000);

        Objects object = new Objects();
        object.setId(1);

        List<AlarmClockHistory> alarmClocks =  new ArrayList<AlarmClockHistory>();

        alarmClocks.add(new AlarmClockHistory("dataTest", "alarm", messageTimestamp, object));

        String parameters = "{\"id\": \""+ object.getId() + "\",\"start\" : \" "+ start.getTime() +" \", \"end\" : \" "+ end.getTime() + "\" ]}";

        given(service.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "alarm", start, end)).willReturn(alarmClocks);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/alarm/alarmClock")
                .content(parameters)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].data").value("dataTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].columnData").value("alarm")
                );

    }

    //@Test
    public void getNightAlarmsHistoryTest() throws Exception {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        Timestamp messageTimestamp = new Timestamp(end.getTime()-7*24*60*60*1000);
        messageTimestamp.setHours(2);

        Objects object = new Objects();
        object.setId(1);

        List<AlarmClockHistory> alarmClocks =  new ArrayList<AlarmClockHistory>();

        alarmClocks.add(new AlarmClockHistory("dataTest", "alarm", messageTimestamp, object));

        String parameters = "{\"id\": \""+ object.getId() + "\",\"start\" : \" "+ start.getTime() +" \", \"end\" : \" "+ end.getTime() + "\" ]}";

        given(objectVerification.nightAlarm(alarmClocks)).willReturn(alarmClocks);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/nightAlarm/alarmClock")
                .content(parameters)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].data").value("dataTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].columnData").value("alarm")
                );

    }
}
