package com.application.aled.service.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.repository.history.LampHistoryRepository;
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
public class LampHistoryServiceImplTest {

    @Mock
    LampHistoryRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    LampHistoryServiceImpl lampService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLampHistoriesByObjectsIdTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<LampHistory> lampHistoriesExpected = new ArrayList<>();
        lampHistoriesExpected.add(new LampHistory("lampHistoriesColor","intensity", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        lampHistoriesExpected.add(new LampHistory("lampHistoriesColor","color", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        lampHistoriesExpected.add(new LampHistory("lampHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));

        given(repository.findByObject_Id(object.getId())).willReturn(lampHistoriesExpected);

        List<LampHistory> lampHistories = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(lampHistories::add);

        List<LampHistory> lampHistoriesTest = new ArrayList<LampHistory>();

        try {
            lampHistoriesTest = lampService.getLampHistoryByObjectsId(object.getId());
        } catch (Exception e){
            Assert.fail("Service lampService failing");
        }

        Assert.assertEquals(lampHistoriesTest, lampHistories);
        Assert.assertNotEquals(lampHistoriesTest, new ArrayList<LampHistory>());
    }

    @Test
    public void getLampHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[3];
        columnsData[0] = "color";
        columnsData[1] = "power";
        columnsData[2] = "intensity";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;
        start.setMonth(end.getMonth() - 1);

        List<LampHistory> lampHistoriesColor = new ArrayList<>();
        lampHistoriesColor.add(new LampHistory("lampHistoriesColor","color", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "color", start, end)).willReturn(lampHistoriesColor);

        List<LampHistory> lampHistoriesPower = new ArrayList<>();
        lampHistoriesPower.add(new LampHistory("lampHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "power", start, end)).willReturn(lampHistoriesPower);

        List<LampHistory> lampHistoriesIntensity = new ArrayList<>();
        lampHistoriesIntensity.add(new LampHistory("lampHistoriesIntensity","intensity", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "intensity", start, end)).willReturn(lampHistoriesIntensity);


        for (String columnData: columnsData) {
            List<LampHistory> lampHistories = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(lampHistories::add);

            List<LampHistory> lampHistoriesTest = new ArrayList<LampHistory>();

            try {
                lampHistoriesTest = lampService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);
            } catch (Exception e){
                Assert.fail("Service lampService failing");
            }

            if(columnData == "power"){
                Assert.assertEquals(lampHistoriesTest, lampHistoriesPower);
            } else if(columnData == "color") {
                Assert.assertEquals(lampHistoriesTest, lampHistoriesColor);
            } else {
                Assert.assertEquals(lampHistoriesTest, lampHistoriesIntensity);
            }

            Assert.assertNotEquals(lampHistoriesTest, new ArrayList<LampHistory>());
        }
    }

    @Test
    public void getLampHistoriesByObjectsIdAndColumnAndDateBetweenIsNotNullButEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        try {
            List<LampHistory> lampHistoriesTest = lampService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
            Assert.assertNotNull(lampHistoriesTest);
            Assert.assertEquals(lampHistoriesTest, new ArrayList<LampHistory>());
        } catch (Exception e){
            Assert.fail("Service lampService failing");
        }
    }
}
