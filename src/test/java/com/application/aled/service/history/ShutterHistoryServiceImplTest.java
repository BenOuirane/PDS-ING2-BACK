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

import static org.mockito.BDDMockito.given;

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
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<ShutterHistory> shutterHistoriesExpected = new ArrayList<>();
        shutterHistoriesExpected.add(new ShutterHistory("shutterHistoriesAction","action", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        shutterHistoriesExpected.add(new ShutterHistory("shutterHistoriesTemperature","temp", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));

        given(repository.findByObject_Id(object.getId())).willReturn(shutterHistoriesExpected);

        List<ShutterHistory> shutterHistories = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(shutterHistories::add);

        List<ShutterHistory> shutterHistoriesTest = new ArrayList<ShutterHistory>();

        try {
            shutterHistoriesTest = shutterService.getShutterHistoryByObjectsId(object.getId());
        } catch (Exception e){
            Assert.fail("Service shutterService failing");
        }

        Assert.assertEquals(shutterHistoriesTest, shutterHistories);
        Assert.assertNotEquals(shutterHistoriesTest, new ArrayList<ShutterHistory>());
    }

    @Test
    public void getShutterHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;
        start.setMonth(end.getMonth() - 1);

        List<ShutterHistory> shutterHistoriesAction = new ArrayList<>();
        shutterHistoriesAction.add(new ShutterHistory("shutterHistoriesAction","action", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "action", start, end)).willReturn(shutterHistoriesAction);


        List<ShutterHistory> shutterHistories = new ArrayList<>();

        repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "action", start, end).forEach(shutterHistories::add);

        List<ShutterHistory> shutterHistoriesTest = new ArrayList<ShutterHistory>();

        try {
            shutterHistoriesTest = shutterService.getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "action", start, end);
        } catch (Exception e){
            Assert.fail("Service shutterService failing");
        }

        Assert.assertEquals(shutterHistoriesTest, shutterHistoriesAction);


        Assert.assertNotEquals(shutterHistoriesTest, new ArrayList<ShutterHistory>());

    }

    @Test
    public void getShutterHistoriesByObjectsIdAndColumnAndDateBetweenIsNotNullButEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        try {
            List<ShutterHistory> shutterHistoriesTest = shutterService.getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
            Assert.assertNotNull(shutterHistoriesTest);
            Assert.assertEquals(shutterHistoriesTest, new ArrayList<ShutterHistory>());
        } catch (Exception e){
            Assert.fail("Service shutterService failing");
        }
    }
}
