package com.application.aled.service.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.repository.history.AlarmClockHistoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AlarmClockHistoryServiceImplTest {

    @Mock
    AlarmClockHistoryRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    AlarmClockHistoryServiceImpl alarmClockService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAlarmClockHistoriesByObjectsIdTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<AlarmClockHistory> alarmClockHistoriesExpected = new ArrayList<>();
        alarmClockHistoriesExpected.add(new AlarmClockHistory("alarmClockHistoriesAlarm","alarm", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        alarmClockHistoriesExpected.add(new AlarmClockHistory("alarmClockHistoriesRadio","radio", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));

        given(repository.findByObject_Id(object.getId())).willReturn(alarmClockHistoriesExpected);

        List<AlarmClockHistory> alarmClockHistories = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(alarmClockHistories::add);

        List<AlarmClockHistory> alarmClockHistoriesTest = new ArrayList<AlarmClockHistory>();

        try {
            alarmClockHistoriesTest = alarmClockService.getAlarmClockHistoryByObjectsId(object.getId());
        } catch (Exception e){
            Assert.fail("Service alarmClockService failing");
        }

        Assert.assertEquals(alarmClockHistoriesTest, alarmClockHistories);
        Assert.assertNotEquals(alarmClockHistoriesTest, new ArrayList<AlarmClockHistory>());
    }

    @Test
    public void getAlarmClockHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[2];
        columnsData[0] = "alarm";
        columnsData[1] = "radio";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;
        start.setMonth(end.getMonth() - 1);

        List<AlarmClockHistory> alarmClockHistoriesAlarm = new ArrayList<>();
        alarmClockHistoriesAlarm.add(new AlarmClockHistory("alarmClockHistoriesAlarm","alarm", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "alarm", start, end)).willReturn(alarmClockHistoriesAlarm);

        List<AlarmClockHistory> alarmClockHistoriesRadio = new ArrayList<>();
        alarmClockHistoriesRadio.add(new AlarmClockHistory("alarmClockHistoriesRadio","radio", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "radio", start, end)).willReturn(alarmClockHistoriesRadio);

        for (String columnData: columnsData) {
            List<AlarmClockHistory> alarmClockHistories = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(alarmClockHistories::add);

            List<AlarmClockHistory> alarmClockHistoriesTest = new ArrayList<AlarmClockHistory>();

            try {
                alarmClockHistoriesTest = alarmClockService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);
            } catch (Exception e){
                Assert.fail("Service alarmClockService failing");
            }

            if(columnData == "radio"){
                Assert.assertEquals(alarmClockHistoriesTest, alarmClockHistoriesRadio);
            } else {
                Assert.assertEquals(alarmClockHistoriesTest, alarmClockHistoriesAlarm);
            }

            Assert.assertNotEquals(alarmClockHistoriesTest, new ArrayList<AlarmClockHistory>());
        }
    }

    @Test
    public void getAlarmClockHistoriesByObjectsIdAndColumnAndDateBetweenIsNotNullButEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        try {
            List<AlarmClockHistory> alarmClockHistoriesTest = alarmClockService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
            Assert.assertNotNull(alarmClockHistoriesTest);
            Assert.assertEquals(alarmClockHistoriesTest, new ArrayList<AlarmClockHistory>());
        } catch (Exception e){
            Assert.fail("Service alarmClockService failing");
        }
    }
}
