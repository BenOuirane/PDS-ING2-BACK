/**
 * 
 */
package com.application.aled.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatcher.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.application.aled.service.BraceletServiceImpl;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class BraceletControllerTest {
	
	@InjectMocks
	BraceletController braceletController;
	
	@Mock
	BraceletServiceImpl braceletService;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	final void testBraceletId() {
	}
	
}
