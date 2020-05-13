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

import static org.mockito.BDDMockito.given;

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
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<CoffeeMachineHistory> coffeeMachineHistoriesExpected = new ArrayList<>();
        coffeeMachineHistoriesExpected.add(new CoffeeMachineHistory("coffeeMachineHistoriesCapsules","schedule_coffee", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        coffeeMachineHistoriesExpected.add(new CoffeeMachineHistory("coffeeMachineHistoriesPower","capsules", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        coffeeMachineHistoriesExpected.add(new CoffeeMachineHistory("coffeeMachineHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));

        given(repository.findByObject_Id(object.getId())).willReturn(coffeeMachineHistoriesExpected);

        List<CoffeeMachineHistory> coffeeMachineHistories = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(coffeeMachineHistories::add);

        List<CoffeeMachineHistory> coffeeMachineHistoriesTest = new ArrayList<CoffeeMachineHistory>();

        try {
            coffeeMachineHistoriesTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsId(object.getId());
        } catch (Exception e){
            Assert.fail("Service coffeeMachineService failing");
        }

        Assert.assertEquals(coffeeMachineHistoriesTest, coffeeMachineHistories);
        Assert.assertNotEquals(coffeeMachineHistoriesTest, new ArrayList<CoffeeMachineHistory>());
    }

    @Test
    public void getCoffeeMachineHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[3];
        columnsData[0] = "capsules";
        columnsData[1] = "power";
        columnsData[2] = "schedule_coffee";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;
        start.setMonth(end.getMonth() - 1);

        List<CoffeeMachineHistory> coffeeMachineHistoriesCapsules = new ArrayList<>();
        coffeeMachineHistoriesCapsules.add(new CoffeeMachineHistory("coffeeMachineHistoriesCapsules","capsules", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "capsules", start, end)).willReturn(coffeeMachineHistoriesCapsules);

        List<CoffeeMachineHistory> coffeeMachineHistoriesPower = new ArrayList<>();
        coffeeMachineHistoriesPower.add(new CoffeeMachineHistory("coffeeMachineHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "power", start, end)).willReturn(coffeeMachineHistoriesPower);

        List<CoffeeMachineHistory> coffeeMachineHistoriesSchedule = new ArrayList<>();
        coffeeMachineHistoriesSchedule.add(new CoffeeMachineHistory("coffeeMachineHistoriesSchedule","schedule_coffee", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "schedule_coffee", start, end)).willReturn(coffeeMachineHistoriesSchedule);


        for (String columnData: columnsData) {
            List<CoffeeMachineHistory> coffeeMachineHistories = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(coffeeMachineHistories::add);

            List<CoffeeMachineHistory> coffeeMachineHistoriesTest = new ArrayList<CoffeeMachineHistory>();

            try {
                coffeeMachineHistoriesTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);
            } catch (Exception e){
                Assert.fail("Service coffeeMachineService failing");
            }

            if(columnData == "power"){
                Assert.assertEquals(coffeeMachineHistoriesTest, coffeeMachineHistoriesPower);
            } else if(columnData == "capsules") {
                Assert.assertEquals(coffeeMachineHistoriesTest, coffeeMachineHistoriesCapsules);
            } else {
                Assert.assertEquals(coffeeMachineHistoriesTest, coffeeMachineHistoriesSchedule);
            }

            Assert.assertNotEquals(coffeeMachineHistoriesTest, new ArrayList<CoffeeMachineHistory>());
        }
    }

    @Test
    public void getCoffeeMachineHistoriesByObjectsIdAndColumnAndDateBetweenIsNotNullButEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        try {
            List<CoffeeMachineHistory> coffeeMachineHistoriesTest = coffeeMachineService.getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
            Assert.assertNotNull(coffeeMachineHistoriesTest);
            Assert.assertEquals(coffeeMachineHistoriesTest, new ArrayList<CoffeeMachineHistory>());
        } catch (Exception e){
            Assert.fail("Service coffeeMachineService failing");
        }
    }
}
