package com.application.aled.service;
/**
 * Class: CandidateServiceImpl
 * @author: BEN OUIRANE Hajer
 */
import com.application.aled.entity.Candidate;
import com.application.aled.entity.Score;
import com.application.aled.repository.CandidateRepository;
import com.application.aled.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<Candidate> tolist() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate tolistId(int id) {
        return null;
    }





    @Override
    public ArrayList<Candidate> sortScoreAllCandidat() {
        int nbr1 , nbr2 , nbr3 , nbr4 ,nbr5 ,nbr6 ,nbr7 ;
        double coefaoutonomy = 3.1;
        double val ;
        double coefsport = 1.5;
        double coefsocial_activity = 1.5;
        double coeffinance = 3.1;
        double coefetat_sociale = 1.5;
        double coefhabitude= 1.5;
        double coeftype_maladie = 2.1;


        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidates::add);
        /* test score*/
        List<Score> scores  = new ArrayList<>();
        scoreRepository.findAll().forEach(scores::add);

        for (Candidate candidate : candidates) {
            for (Score score : scores) {
                switch (candidate.getSport()) {
                    case "NO_ ATHLETIC":
                        nbr1 = score.getNote_no_athletic();
                        break;
                    case "ATHLETIC":
                        nbr1 = score.getNote_athletic();
                        break;
                    default:
                        nbr1 = 0;
                }
                switch (candidate.getFinance()) {
                    case "GOOD_FINANCIAL_CONDITION":
                        nbr2 = score.getNote_good_financial_condition();
                        break;
                    case "BAD_FINANCIAL_CONDITION":
                        nbr2 = score.getNote_bad_financial_condition();
                        break;

                    default:
                        nbr2 = 0;
                }

                switch (candidate.getAutonomy()) {
                    case "SELF_RULING":
                        nbr3 = score.getNote_self_ruling();
                        break;
                    case "NON_SELF_RULING":
                        nbr3 = score.getNote_no_self_ruling();
                        break;
                    default:
                        nbr3 = 0;
                }
                switch (candidate.getEtat_sociale()) {
                    case "GOOD_SOCIAL_CONDITION":
                        nbr4 = score.getNote_good_social_condition();
                        break;
                    case "BAD_SOCIAL_CONDITION":
                        nbr4 = score.getNote_bad_social_condition();
                        break;
                    default:
                        nbr4 = 0;
                }

                switch (candidate.getSocial_activity()) {
                    case "SOCIABLE":
                        nbr5 = score.getNote_sociable();
                        break;
                    case "NO_SOCIABLE":
                        nbr5 = score.getNote_no_sociable();
                        break;
                    default:
                        nbr5 = 0;
                }

                switch (candidate.getHabit()) {
                    case "LIKE_COOKING":
                        nbr6 = score.getNote_like_cooking();
                        break;
                    case "LIKE_REST":
                        nbr6 = score.getNote_like_rest();
                        break;
                    case "LIKE_GAMES":
                        nbr6 = score.getNote_like_game();
                        break;
                    default:
                        nbr6 = 0;
                }

                switch (candidate.getType_de_maladie()) {
                    case "NOT_SICk":
                        nbr7 = score.getNote_not_sick();
                        break;
                    case "HYPERTENSION":
                        nbr7 = score.getNote_hypertension();
                        break;
                    case "DIABETES":
                        nbr7 = score.getNote_diabetes();
                        break;
                    default:
                        nbr7 = 0;
                }

                val = (coefsport * nbr1) +
                        (coeffinance * nbr2) +
                        (coefaoutonomy * nbr3) +
                        (coefetat_sociale * nbr4) +
                        (coefsocial_activity * nbr5) +
                        (coefhabitude * nbr6) +
                        (coeftype_maladie * nbr7);


                candidate.setScore(val);


                String.valueOf(candidate.getScore());
            }
        }

        Collections.sort(candidates, new Comparator<Candidate>() {

            @Override
            public int compare(Candidate c1, Candidate c2) {

                return -Double.compare(c1.getScore(), c2.getScore());
            }

        });



        return (ArrayList<Candidate>) candidates;

    }

    @Override
    public List<Candidate> getscoreAllCandidat() {

        double nbr1 , nbr2 , nbr3 , nbr4 ,nbr5 ,nbr6 ,nbr7 ;
        double val ;
        double coefaoutonomy = 3.1;
        double coefsport = 1.5;
        double coefsocial_activity = 1.5;
        double coeffinance = 3.1;
        double coefetat_sociale = 1.5;
        double coefhabitude= 1.5;
        double coeftype_maladie = 2.1;


        List<Candidate> candidates = new ArrayList<>();
        candidateRepository.findAll().forEach(candidates::add);
        List<Score> scores  = new ArrayList<>();
        scoreRepository.findAll().forEach(scores::add);

        for (Candidate candidate : candidates) {
            for (Score score : scores) {
                switch (candidate.getSport()){
                    case   "NO_ ATHLETIC":  nbr1=score.getNote_no_athletic();
                        break;
                    case "ATHLETIC": nbr1=score.getNote_athletic();
                        break;
                    default: nbr1=0;
                }
                switch (candidate.getFinance()){
                    case "GOOD_FINANCIAL_CONDITION": nbr2= score.getNote_good_financial_condition();
                        break;
                    case   "BAD_FINANCIAL_CONDITION":  nbr2=score.getNote_bad_financial_condition();
                        break;

                    default: nbr2=0;
                }

                switch (candidate.getAutonomy()){
                    case   "SELF_RULING":  nbr3=score.getNote_self_ruling();
                        break;
                    case "NON_SELF_RULING": nbr3=score.getNote_no_self_ruling();
                        break;
                    default: nbr3=0;
                }
                switch (candidate.getEtat_sociale()){
                    case   "GOOD_SOCIAL_CONDITION":  nbr4=score.getNote_good_social_condition();
                        break;
                    case "BAD_SOCIAL_CONDITION": nbr4=score.getNote_bad_social_condition();
                        break;
                    default: nbr4=0;
                }

                switch (candidate.getSocial_activity()){
                    case   "SOCIABLE":  nbr5=score.getNote_sociable();
                        break;
                    case "NO_SOCIABLE": nbr5=score.getNote_no_sociable();
                        break;
                    default: nbr5=0;
                }

                switch (candidate.getHabit()){
                    case   "LIKE_COOKING":  nbr6=score.getNote_like_cooking();
                        break;
                    case   "LIKE_REST":  nbr6=score.getNote_like_rest();
                        break;
                    case "LIKE_GAMES": nbr6=score.getNote_like_game();
                        break;
                    default: nbr6=0;
                }

                switch (candidate.getType_de_maladie()){
                    case   "NOT_SICk":  nbr7=10.4;
                        break;
                    case   "HYPERTENSION":  nbr7=14.2;
                        break;
                    case "DIABETES": nbr7=14.2;
                        break;
                    default: nbr7=0;
                }

                val=(coefsport*nbr1) +
                        (coeffinance*nbr2) +
                        (coefaoutonomy*nbr3) +
                        (coefetat_sociale*nbr4) +
                        (coefsocial_activity*nbr5) +
                        (coefhabitude*nbr6) +
                        (coeftype_maladie*nbr7);

                //  System.out.println(val);
                candidate.setScore(val);




                String.valueOf(candidate.getScore());

            }}

        return (List<Candidate>) candidates;
    }


}
