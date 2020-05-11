package com.application.aled.service.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.repository.history.CoffeeMachineHistoryRepository;
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
public class CoffeeMachineHistoryServiceImplTest {

    @Mock
    CoffeeMachineHistoryRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    CoffeeMachineHistoryServiceImpl coffeeMachineService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getCoffeeMachineHistoriesByObjectsIdTest() {
        List<CoffeeMachineHistory> coffeeMachineHistory = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(coffeeMachineHistory::add);
        List<CoffeeMachineHistory> coffeeMachineHistoryListTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsId(object.getId());
        Assert.assertEquals(coffeeMachineHistoryListTest, coffeeMachineHistory);
    }

    @Test
    public void getCoffeeMachineHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[3];

        columnsData[0] = "schedule_coffee";
        columnsData[1] = "capsules";
        columnsData[2] = "power";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        for (String columnData: columnsData) {
            List<CoffeeMachineHistory> coffeeMachineHistory = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(coffeeMachineHistory::add);

            List<CoffeeMachineHistory> coffeeMachineHistoryListTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);

            Assert.assertEquals(coffeeMachineHistoryListTest, coffeeMachineHistory);
        }
    }

    @Test
    public void getCoffeeMachineHistoriesByObjectsIdAndColumnAndDateBetweenIsEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<CoffeeMachineHistory> coffeeMachineHistoryListTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
        Assert.assertEquals(coffeeMachineHistoryListTest, new ArrayList<CoffeeMachineHistory>());
    }
}
