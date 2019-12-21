package com.application.aled.service;

import com.application.aled.entity.Object;
import com.application.aled.entity.Rooms;
import com.application.aled.repository.ObjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectServiceImpl implements ObjectService {

    @Autowired
    ObjectRepository objectRepository;

    public List<Object> getObjectByRoom(Rooms room) {
       return objectRepository.findByRooms(room);
    }
}
