package com.application.aled;

import com.application.aled.repository.AnnualSubscriptionRepository;

import com.application.aled.service.AnnualSubscriptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnnualSubscriptionServiceImplTest {
    @Mock
    AnnualSubscriptionRepository annualrepository;

    @InjectMocks
    AnnualSubscriptionServiceImpl annualservice;

    @Test
    public void getSubscriptionByYear() {
        // GIVEN
        int[] annualsubscription = annualrepository.findSubscriptionByYear();
        // WHEN
        int[] annualsubscriptionTest = annualservice.getSubscriptionByYear();
        //THEN
        Assert.assertEquals(annualsubscription, annualsubscriptionTest);
    }
}
