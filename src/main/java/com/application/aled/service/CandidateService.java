package com.application.aled.service;

/**
 * Class: CandidateService
 * @author: BEN OUIRANE Hajer
 */


import com.application.aled.entity.Candidate;


import java.util.ArrayList;
import java.util.List;

public interface CandidateService {

    public List<Candidate> tolist();

    Candidate tolistId(int id);

    public ArrayList<Candidate> sortScoreAllCandidat();

    public List<Candidate> getscoreAllCandidat();


}
