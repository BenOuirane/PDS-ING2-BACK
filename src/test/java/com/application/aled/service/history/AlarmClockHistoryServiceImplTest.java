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
        List<AlarmClockHistory> alarmClockHistory = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(alarmClockHistory::add);
        List<AlarmClockHistory> alarmClockHistoryListTest = alarmClockService.getAlarmClockHistoryByObjectsId(object.getId());
        Assert.assertEquals(alarmClockHistoryListTest, alarmClockHistory);
    }

    @Test
    public void getAlarmClockHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[2];

        columnsData[0] = "alarm";
        columnsData[1] = "radio";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        for (String columnData: columnsData) {
            List<AlarmClockHistory> alarmClockHistory = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(alarmClockHistory::add);

            List<AlarmClockHistory> alarmClockHistoryListTest = alarmClockService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);

            Assert.assertEquals(alarmClockHistoryListTest, alarmClockHistory);
        }
    }

    @Test
    public void getAlarmClockHistoriesByObjectsIdAndColumnAndDateBetweenIsEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<AlarmClockHistory> alarmClockHistoryListTest = alarmClockService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
        Assert.assertEquals(alarmClockHistoryListTest, new ArrayList<AlarmClockHistory>());
    }
}
