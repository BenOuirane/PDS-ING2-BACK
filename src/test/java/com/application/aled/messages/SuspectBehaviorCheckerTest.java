package com.application.aled.messages;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.service.FailureService;
import com.application.aled.service.ObjectService;
import com.application.aled.service.history.OvenHistoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;

@RunWith(MockitoJUnitRunner.class)
public class SuspectBehaviorCheckerTest {

    @Mock
    OvenHistoryService ovenHistoryService;
    @Mock
    ObjectService objectService;
    @Mock
    FailureService failureService;

    @InjectMocks
    SuspectBehaviorChecker suspectBehaviorChecker;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

            //failureService.addFailure(new Failure(messageError, new Timestamp(System.currentTimeMillis()) , null, objectToCheck));

    @Test
    public void messageAlreadyDetectedTodayTest(){
        //Initialisation
        Objects objectToCheck = new Objects();
        objectToCheck.setId(15);
        objectToCheck.setObjectType("OVEN");
        objectToCheck.setState(true);
        String messageError = "Temperature is too high";

        //Transition
        boolean alreadyDetectedToday = suspectBehaviorChecker.messageAlreadyDetectedToday(objectToCheck, messageError);

        //Verification
        Assert.assertFalse("We found an existing message",alreadyDetectedToday);
    }
    @Test
    public void behaviorAnalystTestNormalValue(){
        //Initialisation
        int temperature = 30;
        //Transition
        String answer = suspectBehaviorChecker.behaviorAnalyst(temperature);
        //Verification
        Assert.assertEquals("the analyst doesn't give right answer","", answer );
    }
    @Test
    public void behaviorAnalystTestLowValue(){
        //Initialisation
        int temperature = 5;
        //Transition
        String answer = suspectBehaviorChecker.behaviorAnalyst(temperature);
        //Verification
        Assert.assertEquals("the analyst doesn't give right answer", "Temperature is too low",answer );
    }
    @Test
    public void behaviorAnalystTestHighValue(){
        //Initialisation
        int temperature = 500;
        //Transition
        String answer = suspectBehaviorChecker.behaviorAnalyst(temperature);
        //Verification
        Assert.assertEquals("the analyst doesn't give right answer","Temperature is too high", answer );
    }
    @Test
    public void warmSpeedAnalystTest(){
        //Initialisation
        int secondDiff=100;
        int temperatureDifference=1;

        //Transition
        boolean temperatureGrowTooFast = suspectBehaviorChecker.warmSpeedAnalyst(secondDiff,temperatureDifference);

        //Verification
        Assert.assertFalse(temperatureGrowTooFast);
    }
    @Test
    public void warmSpeedAnalystTestWithZero(){
        //Initialisation
        int secondDiff=0;
        int temperatureDifference=0;

        //Transition
        boolean temperatureGrowTooFast = suspectBehaviorChecker.warmSpeedAnalyst(secondDiff,temperatureDifference);

        //Verification
        Assert.assertFalse(temperatureGrowTooFast);
    }
    @Test
    public void warmSpeedAnalystTestBadBehavior(){
        //Initialisation
        int secondDiff=10;
        int temperatureDifference=100;

        //Transition
        boolean temperatureGrowTooFast = suspectBehaviorChecker.warmSpeedAnalyst(secondDiff,temperatureDifference);

        //Verification
        Assert.assertTrue(temperatureGrowTooFast);
    }
}
