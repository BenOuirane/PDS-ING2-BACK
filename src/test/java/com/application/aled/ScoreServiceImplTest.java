package com.application.aled;

/**
 * Class: ScoreServiceImplTest
 * @author: BEN OUIRANE Hajer
 */



import com.application.aled.entity.Score;
import com.application.aled.repository.ScoreRepository;
import com.application.aled.service.ScoreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceImplTest {


    @InjectMocks
    private ScoreServiceImpl scoreService ;

    @Mock
    private ScoreRepository repository;

    @Mock
    private Score score;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


      @Test
    public void testadd(){

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

          Mockito.when(repository.save(score)).thenReturn(score);
          assert(scoreService.add(score)).equals(score);


      }



}
