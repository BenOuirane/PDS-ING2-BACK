package com.application.aled.service.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.repository.history.OvenHistoryRepository;
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
public class OvenHistoryServiceImplTest {

    @Mock
    OvenHistoryRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    OvenHistoryServiceImpl ovenService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOvenHistoriesByObjectsIdTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<OvenHistory> ovenHistoriesExpected = new ArrayList<>();
        ovenHistoriesExpected.add(new OvenHistory("ovenHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        ovenHistoriesExpected.add(new OvenHistory("ovenHistoriesTemperature","temp", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));

        given(repository.findByObject_Id(object.getId())).willReturn(ovenHistoriesExpected);

        List<OvenHistory> ovenHistories = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(ovenHistories::add);

        List<OvenHistory> ovenHistoriesTest = new ArrayList<OvenHistory>();

        try {
            ovenHistoriesTest = ovenService.getOvenHistoryByObjectsId(object.getId());
        } catch (Exception e){
            Assert.fail("Service ovenService failing");
        }

        Assert.assertEquals(ovenHistoriesTest, ovenHistories);
        Assert.assertNotEquals(ovenHistoriesTest, new ArrayList<OvenHistory>());
    }

    @Test
    public void getOvenHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[2];
        columnsData[0] = "power";
        columnsData[1] = "temp";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;
        start.setMonth(end.getMonth() - 1);

        List<OvenHistory> ovenHistoriesPower = new ArrayList<>();
        ovenHistoriesPower.add(new OvenHistory("ovenHistoriesPower","power", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "power", start, end)).willReturn(ovenHistoriesPower);

        List<OvenHistory> ovenHistoriesTemperature = new ArrayList<>();
        ovenHistoriesTemperature.add(new OvenHistory("ovenHistoriesTemperature","temp", new Timestamp(new Date().getTime()-7*24*60*60*1000), object));
        given(repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), "temp", start, end)).willReturn(ovenHistoriesTemperature);

        for (String columnData: columnsData) {
            List<OvenHistory> ovenHistories = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(ovenHistories::add);

            List<OvenHistory> ovenHistoriesTest = new ArrayList<OvenHistory>();

            try {
                ovenHistoriesTest = ovenService.getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);
            } catch (Exception e){
                Assert.fail("Service ovenService failing");
            }

            if(columnData == "temp"){
                Assert.assertEquals(ovenHistoriesTest, ovenHistoriesTemperature);
            } else {
                Assert.assertEquals(ovenHistoriesTest, ovenHistoriesPower);
            }

            Assert.assertNotEquals(ovenHistoriesTest, new ArrayList<OvenHistory>());
        }
    }

    @Test
    public void getOvenHistoriesByObjectsIdAndColumnAndDateBetweenIsNotNullButEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        try {
            List<OvenHistory> ovenHistoriesTest = ovenService.getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
            Assert.assertNotNull(ovenHistoriesTest);
            Assert.assertEquals(ovenHistoriesTest, new ArrayList<OvenHistory>());
        } catch (Exception e){
            Assert.fail("Service ovenService failing");
        }
    }
}
