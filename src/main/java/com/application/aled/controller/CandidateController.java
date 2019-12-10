/**
 * Class: CandidateController
 * @author: BEN OUIRANE Hajer
 * @version: 1.0
 */

package com.application.aled.controller;
import com.application.aled.entity.Candidate;
import com.application.aled.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    /**
     * Final variable
     */
    private final CandidateRepository candidateRepository;
    /**
     * Initilazation
     */
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    /**
     * Retrieve All candidates
     */

    @GetMapping("/candidates")
    public List<Candidate> getCandidate() {
        return (List<Candidate>) candidateRepository.findAll();
    }

    /**
     * Method that create candidate in our database
     */

    @PostMapping("/candidates")
    void addCandidate(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
    }



}
