package com.application.aled.controller;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import com.application.aled.service.ObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ObjectController {

    @Autowired
    ObjectServiceImpl objectService;

    Logger logger = Logger.getLogger("com.application.aled.controller.ObjectController");

    @PutMapping("/object/list")
    public List<Objects> getAllObject(@RequestBody Rooms rooms){
        logger.info("Call getAllObject :" + rooms.toString());
        List<Objects> _objects = objectService.getObjectByRoom(rooms);
        return _objects;
    }



}
