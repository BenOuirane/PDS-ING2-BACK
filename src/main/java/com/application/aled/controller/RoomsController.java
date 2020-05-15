package com.application.aled.controller;

import com.application.aled.entity.Resident;
import com.application.aled.entity.Rooms;
import com.application.aled.entity.User;
import com.application.aled.repository.ResidentRepository;
import com.application.aled.service.ResidentServiceImpl;
import com.application.aled.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class RoomsController {

    @Autowired
    private RoomServiceImpl roomService;

    @GetMapping(value = "/rooms")
    public List<Rooms> getAllRooms() {
        List<Rooms> rooms = roomService.getRooms();
        return rooms;
    }
    
    @GetMapping(value = "/roomsize")
    public int getAllRoomsize() {
        int rooms = roomService.getRooms().size();
        return rooms;
    }
}


