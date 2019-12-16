/**
 * Class: CandidateController
 * @author: BEN OUIRANE Hajer
 * @version: 1.1
 */

package com.application.aled.controller;
import com.application.aled.entity.Candidate;
import com.application.aled.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class CandidateController {


    /**
     * Import the specific repository we need
     */
    @Autowired
    private CandidateRepository candidateRepository;



    /**
     * Retrieve All candidates
     */

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {

        System.out.println("Get all Customers...");

        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidates::add);

        return candidates;

    }

    /**
     * Method that create candidate in our database
     */
     Map<String, String> errors;
    @PostMapping( "/candidates/create")
    public ResponseEntity<Object> postCandidate(@RequestBody @Valid  Candidate candidate, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){

            errors = new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
         Candidate c = candidateRepository.findBymail(candidate.getMail());
        if(c!=null){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(candidateRepository.save(candidate),HttpStatus.OK);
    }


}

