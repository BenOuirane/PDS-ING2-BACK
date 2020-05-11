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
        List<LampHistory> lampHistory = new ArrayList<>();
        repository.findByObject_Id(object.getId()).forEach(lampHistory::add);
        List<LampHistory> lampHistoryListTest = lampService.getLampHistoryByObjectsId(object.getId());
        Assert.assertEquals(lampHistoryListTest, lampHistory);
    }

    @Test
    public void getLampHistoriesByObjectsIdAndColumnAndDateBetweenTest() {
        String[] columnsData = new String[3];

        columnsData[0] = "color";
        columnsData[1] = "intensity";
        columnsData[2] = "power";

        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        for (String columnData: columnsData) {
            List<LampHistory> lampHistory = new ArrayList<>();

            repository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(object.getId(), columnData, start, end).forEach(lampHistory::add);

            List<LampHistory> lampHistoryListTest = lampService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), columnData, start, end);

            Assert.assertEquals(lampHistoryListTest, lampHistory);
        }
    }

    @Test
    public void getLampHistoriesByObjectsIdAndColumnAndDateBetweenIsEmptyTest() {
        Timestamp end = new Timestamp(new Date().getTime());
        Timestamp start = end;

        start.setMonth(end.getMonth() - 1);

        List<LampHistory> lampHistoryListTest = lampService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(object.getId(), "null", start, end);
        Assert.assertEquals(lampHistoryListTest, new ArrayList<LampHistory>());
    }
}
