package com.application.aled.service.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.repository.history.ShutterHistoryRepository;
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
public class ShutterHistoryServiceImplTest {

    @Mock
    ShutterHistoryRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    ShutterHistoryServiceImpl shutterService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getShutterHistoriesByObjectsIdTest() {
        List<ShutterHistory> shutterHistory = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(shutterHistory::add);
        List<ShutterHistory> shutterHistoryListTest = shutterService.getShutterHistoryByObjectsId(object.getId());
        Assert.assertEquals(shutterHistoryListTest, shutterHistory);
    }

    @Test
    public void getShutterHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[1];

        columnsData[0] = "action";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        for (String columnData: columnsData) {
            List<ShutterHistory> shutterHistory = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(shutterHistory::add);

            List<ShutterHistory> shutterHistoryListTest = shutterService.getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);

            Assert.assertEquals(shutterHistoryListTest, shutterHistory);
        }
    }

    @Test
    public void getShutterHistoriesByObjectsIdAndColumnAndDateBetweenIsEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<ShutterHistory> shutterHistoryListTest = shutterService.getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
        Assert.assertEquals(shutterHistoryListTest, new ArrayList<ShutterHistory>());
    }
}
