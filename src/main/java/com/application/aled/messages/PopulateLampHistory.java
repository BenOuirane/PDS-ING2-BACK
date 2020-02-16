package com.application.aled.messages;

import com.application.aled.entity.LampHistory;
import com.application.aled.entity.Objects;
import com.application.aled.entity.ObjectsHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PopulateLampHistory {

    public List<LampHistory> createLampHistory(List<Objects> objectsList, Date weekAgo) {
        List<LampHistory> lampHistories = new ArrayList<LampHistory>();

        // Getting messages timestamps
        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();
        List<ObjectsHistory> objectsHistoriesLampsMorning = populateObjectsHistory.setMessagesTimestamps(objectsList.subList(0,3) , weekAgo, 6, 9, 7);

        for (ObjectsHistory objectsHistory : objectsHistoriesLampsMorning) {
            lampHistories.add(new LampHistory("null", "null", objectsHistory.getMessageTimestamp(), objectsHistory.getObject()));
        }

        return lampHistories;
    }

}
