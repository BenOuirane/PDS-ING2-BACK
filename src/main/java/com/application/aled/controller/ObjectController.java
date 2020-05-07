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

    @PutMapping("/object/id")
    public Objects getObjectById(@RequestBody long id){
        logger.info("Call getId :" + id);
        Objects _objects = objectService.getObjectsById(id);
        return _objects;
    }

    @PutMapping("/object/list")
    public List<Objects> getAllObject(@RequestBody Rooms rooms){
        logger.info("Call getAllObject :" + rooms.toString());
        List<Objects> _objects = objectService.getObjectByRoom(rooms);
        return _objects;
    }
    
    @GetMapping(value = "/objectsize")
    public int getAllObjectSize() {
        logger.info("getting the total of all the objects");
        int objects = objectService.getObjects().size();
        return objects;
    }




}
