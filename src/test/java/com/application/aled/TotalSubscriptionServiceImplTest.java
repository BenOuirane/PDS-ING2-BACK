package com.application.aled;

import com.application.aled.repository.TotalSubscriptionRepository;
import com.application.aled.service.TotalSubscriptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TotalSubscriptionServiceImplTest {
    @Mock
    TotalSubscriptionRepository totalrepository;

    @InjectMocks
    TotalSubscriptionServiceImpl totalservice;

    @Test
    public void getSubscriptionByNameTest() {
       
    	//GIVEN
        int[] totalsubscriptions2019  = totalrepository.findSubscriptionByName(2019);
       

        //WHEN
        int[] totalsubscriptions2019Test = totalservice.getSubscriptionByName(2019);

        //THEN
        Assert.assertArrayEquals(totalsubscriptions2019, totalsubscriptions2019Test);
        

    }
}
