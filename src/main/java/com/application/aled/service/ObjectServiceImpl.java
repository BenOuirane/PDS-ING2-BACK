package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import com.application.aled.repository.ObjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.application.aled.repository.RoomRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Transient;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    RoomRepository roomRepository;


    @Transactional
    public List<Objects> getObjectByRoom(Rooms room) {
       List <Objects> objects = new ArrayList<Objects>();
       Rooms roomFound = roomRepository.findById(room.getIdRoom()).orElse(room);
       objects = objectRepository.findByRooms(room);

       System.out.println("getObjectByRoom" + objects);
       return objects;
    }


}
