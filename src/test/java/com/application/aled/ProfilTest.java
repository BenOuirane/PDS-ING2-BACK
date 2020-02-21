package com.application.aled;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Profil;
import com.application.aled.repository.ProfilRepository;
import com.application.aled.service.ProfilServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProfilTest {

    //Statement state = conn.createStatement();

    @Mock
    ProfilRepository profil;

    @InjectMocks
    ProfilServiceImpl profilService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CustomHandler.class)
    public void assertObjectsEnum() {
        Profil _profil = new Profil();
    }
        //("INSERT INTO profil VALUES(sociable, SOCIABLE, GOOD_SOCIAL_STATE, LAMP)");

}
