package com.application.aled;

import com.application.aled.entity.User;
import com.application.aled.repository.UserRepository;
import com.application.aled.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void listAllUserShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<User> userList = new ArrayList<>();
        repository.findAll().forEach(userList::add);

        //
        // WHEN
        //
        List<User> userListTest = userService.getUsers();

        //
        // THEN
        //
        Assert.assertEquals(userList, userListTest);
    }
}
