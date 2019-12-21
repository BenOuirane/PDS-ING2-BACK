package com.application.aled.controller;

import com.application.aled.entity.Object;
import com.application.aled.entity.Rooms;
import com.application.aled.service.ObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectController {

    @Autowired
    ObjectServiceImpl objectService;

    @PutMapping("/object/infos")
    public List<Object> getAllObject(@RequestBody Rooms rooms){
        System.out.println("Call createNotification");

        List<Object> objects = objectService.getObjectByRoom(rooms);
        return objects;
    }

}
