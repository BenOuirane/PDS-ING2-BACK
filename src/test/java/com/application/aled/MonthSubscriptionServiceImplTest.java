package com.application.aled;

import com.application.aled.repository.MonthSubscriptionRepository;
import com.application.aled.service.MonthSubscriptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MonthSubscriptionServiceImplTest {

    @Mock
    MonthSubscriptionRepository mensualrepository;

    @InjectMocks
    MonthSubscriptionServiceImpl mensualservice;

    @Test
    public void getSubscriptionByMonth() {
        // GIVEN
        int[] mensualsubscription2020 = mensualrepository.findSubscriptionByMonth(2020);

        //WHEN
        int[] mensualsubscriptionTest2020 = mensualservice.getSubscriptionByMonth(2020);

        //THEN
        Assert.assertArrayEquals(mensualsubscription2020, mensualsubscriptionTest2020);
    }
}
