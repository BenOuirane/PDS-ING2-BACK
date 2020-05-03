package com.application.aled;

import com.application.aled.controller.ResidenceController;
import com.application.aled.entity.Residence;
import com.application.aled.entity.User;
import com.application.aled.repository.ResidenceRepository;
import com.application.aled.repository.UserRepository;
import com.application.aled.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class ResidenceControllerTest {
    @Mock
    ResidenceRepository repository;

    @InjectMocks
    ResidenceController residenceController;

    @Test
    public void listAllResidents() {
        // GIVEN
        List<Residence> residence = new ArrayList<>();

        repository.findAll().forEach(residence::add);
        // WHEN
        List<Residence> residenceTest = residenceController.getResidence();
        // THEN
        Assert.assertEquals(residence, residenceTest);
    }
}
