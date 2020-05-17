/**
 * 
 */
package com.application.aled.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.application.aled.repository.AreaRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AreaControllerTest {

	@Mock
	AreaRepository areaRepository; 
		
	@InjectMocks
	AreaController areaController;
	
	
}
