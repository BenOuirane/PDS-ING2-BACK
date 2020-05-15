package com.application.aled.controller;
/**
 * Class: CandidateController
 * @author: BEN OUIRANE Hajer

 */


import com.application.aled.entity.Candidate;
import com.application.aled.entity.Score;
import com.application.aled.repository.CandidateRepository;
import com.application.aled.repository.ScoreRepository;
import com.application.aled.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidateController{


    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidate")
    public List<Candidate> tolist() {

        return candidateService.tolist();
    }


    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ScoreRepository scoreRepository;


    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {

        System.out.println("Get all Candidate...");

        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidates::add);


        return candidates;

    }


    @GetMapping("/score")
    public List<Candidate> getscoreAllCandidat() {

        return candidateService.getscoreAllCandidat();
    }


    Map<String, String> errors;

    @PostMapping("/candidates/create")
    public ResponseEntity<Object> postCandidate(@RequestBody @Valid Candidate candidate, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Candidate c = candidateRepository.findBymail(candidate.getMail());
        if (c != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(candidateRepository.save(candidate), HttpStatus.OK);
    }





    @GetMapping("/sort")
    public ArrayList<Candidate> sortScoreAllCandidat() {

        return candidateService.sortScoreAllCandidat();
    }













}

