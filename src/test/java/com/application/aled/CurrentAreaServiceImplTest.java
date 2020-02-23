package com.application.aled;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.CurrentArea;
import com.application.aled.repository.CurrentAreaRepository;
import com.application.aled.service.CurrentAreaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CurrentAreaServiceImplTest {

	@Mock 
	CurrentAreaRepository currentarearepository;
	
	@InjectMocks
	CurrentAreaServiceImpl currentareaservice;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	//TODO double check this unit test, and change the parameters
	@Test(expected = CustomHandler.class) 
	public void assertAreaEnum() {
		CurrentArea _currentarea = new CurrentArea();
		_currentarea.setId(null);
	}
	
	@Test(expected = CustomHandler.class)
	public void assertCurrentAreaEnum() {
		CurrentArea _currentarea = new CurrentArea();
		_currentarea.setCreatedOn(null);
		}
		
}
