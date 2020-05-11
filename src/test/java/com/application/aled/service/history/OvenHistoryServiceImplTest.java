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
        List<OvenHistory> ovenHistory = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(ovenHistory::add);
        List<OvenHistory> ovenHistoryListTest = ovenService.getOvenHistoryByObjectsId(object.getId());
        Assert.assertEquals(ovenHistoryListTest, ovenHistory);
    }

    @Test
    public void getOvenHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[2];

        columnsData[0] = "temp";
        columnsData[0] = "power";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        for (String columnData: columnsData) {
            List<OvenHistory> ovenHistory = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(ovenHistory::add);

            List<OvenHistory> ovenHistoryListTest = ovenService.getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);

            Assert.assertEquals(ovenHistoryListTest, ovenHistory);
        }
    }

    @Test
    public void getOvenHistoriesByObjectsIdAndColumnAndDateBetweenIsEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<OvenHistory> ovenHistoryListTest = ovenService.getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
        Assert.assertEquals(ovenHistoryListTest, new ArrayList<OvenHistory>());
    }
}
