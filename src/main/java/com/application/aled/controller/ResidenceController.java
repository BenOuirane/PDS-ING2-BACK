package com.application.aled.controller;

import com.application.aled.entity.Residence;
import com.application.aled.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ResidenceController {


        @Autowired
        private ResidenceRepository residenceRepository;

        public ResidenceController(ResidenceRepository residenceRepository) {
            super();
            this.residenceRepository = residenceRepository;

        }

        @GetMapping("/residence")
        public List<Residence> getResidence(){
            List<Residence> residence = residenceRepository.findAll();
            return residence;
        }

        @GetMapping("/totalres")
        public int[] getTotalResidence(){
        int[] total = residenceRepository.findResidence();
        return total;
    }


}
