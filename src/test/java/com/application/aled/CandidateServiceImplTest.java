package com.application.aled;

/**
 * Class: CandidateServiceImplTest
 * @author: BEN OUIRANE Hajer
 */


import com.application.aled.entity.Candidate;
import com.application.aled.entity.Score;
import com.application.aled.repository.CandidateRepository;
import com.application.aled.repository.ScoreRepository;
import com.application.aled.service.CandidateServiceImpl;
import com.application.aled.service.ScoreServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceImplTest {




    @InjectMocks
    private CandidateServiceImpl candidateService ;

    @Mock
    private CandidateRepository repository;


    @Mock
    private Candidate candidate;

    @InjectMocks
    private ScoreServiceImpl scoreService ;

    @Mock
    private ScoreRepository repositoryScore;

    @Mock
    private Score score;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }



     @Test
    public  void tolist(){

          Candidate candidate1 = new Candidate();

          candidate1.setId((long) 1);
          candidate1.setAge("20");
          candidate1.setScore(70);
          candidate1.setFirstname("hajer");
          candidate1.setLastname("ben");
          candidate1.setGenre("W");
          candidate1.setMail("ben@yahoo.com");
          candidate1.setAutonomy("SELF_RULING ");
          candidate1.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
          candidate1.setFinance("GOOD_FINANCIAL_CONDITION");
          candidate1.setHabit("LIKE_GAMES ");
          candidate1.setSocial_activity("SOCIABLE ");
          candidate1.setSport("ATHLETIC ");
          candidate1.setType_de_maladie("NOT_SICk ");



          Candidate candidate2 = new Candidate();

         candidate2.setId((long) 2);
         candidate2.setAge("21");
         candidate2.setScore(71);
         candidate2.setFirstname("insaf");
         candidate2.setLastname("bach");
         candidate2.setGenre("W");
         candidate2.setMail("bach@yahoo.com");
         candidate2.setAutonomy("SELF_RULING ");
         candidate2.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
         candidate2.setFinance("GOOD_FINANCIAL_CONDITION");
         candidate2.setHabit("LIKE_GAMES ");
         candidate2.setSocial_activity("SOCIABLE ");
         candidate2.setSport("ATHLETIC ");
         candidate2.setType_de_maladie("NOT_SICk ");

         List<Candidate> candidateList = new ArrayList<>();
         candidateList.add(candidate1);
         candidateList.add(candidate2);

         Mockito.when(repository.findAll()).thenReturn(candidateList);
         assertThat(candidateService.tolist(), is(equalTo(candidateList)));




     }


    @Test
    public  void  getscoreAllCandidat() throws AssertionError {

        Candidate candidate1 = new Candidate();

        candidate1.setId((long) 1);
        candidate1.setAge("20");
        candidate1.setFirstname("hajer");
        candidate1.setLastname("ben");
        candidate1.setGenre("W");
        candidate1.setMail("ben@yahoo.com");
        candidate1.setAutonomy("SELF_RULING ");
        candidate1.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate1.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate1.setHabit("LIKE_GAMES ");
        candidate1.setSocial_activity("SOCIABLE ");
        candidate1.setSport("ATHLETIC ");
        candidate1.setType_de_maladie("NOT_SICk ");




        Score score = new Score();

        score.setNote_athletic(10);
        score.setNote_bad_financial_condition(20);
        score.setNote_bad_social_condition(30);
        score.setNote_diabetes(10);
        score.setNote_good_financial_condition(40);
        score.setNote_good_social_condition(20);
        score.setNote_hypertension(10);
        score.setNote_like_cooking(5);
        score.setNote_like_game(10);
        score.setNote_like_rest(5);
        score.setNote_no_athletic(10);
        score.setNote_no_self_ruling(30);
        score.setNote_no_sociable(30);
        score.setNote_not_sick(5);
        score.setNote_self_ruling(10);
        score.setNote_sociable(20);

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score);

        Mockito.when(repository.findAll()).thenReturn(candidateList);
        Mockito.when(repositoryScore.findAll()).thenReturn(scoreList);

        List<Candidate> candidates = new ArrayList<>();
        candidates = candidateService.getscoreAllCandidat();

        final double DELTA = 1e-15;

        assertEquals(candidate1.getScore(), 124,  DELTA);



    }


    @Test
    public  void  sortScoreAllCandidat() throws AssertionError {

        Candidate candidate1 = new Candidate();

        candidate1.setId((long) 1);
        candidate1.setAge("20");
        candidate1.setFirstname("hajer");
        candidate1.setLastname("ben");
        candidate1.setGenre("W");
        candidate1.setMail("ben@yahoo.com");
        candidate1.setAutonomy("SELF_RULING ");
        candidate1.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate1.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate1.setHabit("LIKE_GAMES ");
        candidate1.setSocial_activity("SOCIABLE ");
        candidate1.setSport("ATHLETIC ");
        candidate1.setType_de_maladie("NOT_SICk ");


        Candidate candidate2 = new Candidate();

        candidate2.setId((long) 2);
        candidate2.setAge("21");
        candidate2.setFirstname("insaf");
        candidate2.setLastname("bach");
        candidate2.setGenre("W");
        candidate2.setMail("bach@yahoo.com");
        candidate2.setAutonomy("NO_SELFE_RULING ");
        candidate2.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate2.setFinance("BAD_FINANCIAL_CONDITION");
        candidate2.setHabit("LIKE_COOKING  ");
        candidate2.setSocial_activity("SOCIABLE ");
        candidate2.setSport("ATHLETIC ");
        candidate2.setType_de_maladie("HYPERTENSION");

        Score score = new Score();

        score.setNote_athletic(10);
        score.setNote_bad_financial_condition(20);
        score.setNote_bad_social_condition(30);
        score.setNote_diabetes(10);
        score.setNote_good_financial_condition(40);
        score.setNote_good_social_condition(20);
        score.setNote_hypertension(10);
        score.setNote_like_cooking(5);
        score.setNote_like_game(10);
        score.setNote_like_rest(5);
        score.setNote_no_athletic(10);
        score.setNote_no_self_ruling(30);
        score.setNote_no_sociable(30);
        score.setNote_not_sick(5);
        score.setNote_self_ruling(10);
        score.setNote_sociable(20);

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);

        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score);

        Mockito.when(repository.findAll()).thenReturn(candidateList);
        Mockito.when(repositoryScore.findAll()).thenReturn(scoreList);

        List<Candidate> candidates = new ArrayList<>();
        candidates = candidateService.sortScoreAllCandidat();
        assertEquals( candidates, candidateList);





    }






}
