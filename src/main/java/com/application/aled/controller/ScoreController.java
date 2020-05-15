package com.application.aled.controller;
/**
 * Class: ScoreController
 * @author: BEN OUIRANE Hajer

 */
import com.application.aled.entity.Score;
import com.application.aled.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    ScoreService service;

    @PostMapping("/note")
    public Score createScore(@RequestBody Score score){
        return  service.add(score);
    }
}

