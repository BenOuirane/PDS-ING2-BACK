package com.application.aled.service;

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
import com.application.aled.entity.CurrentArea;
import com.application.aled.repository.CurrentAreaRepository;

@RunWith(MockitoJUnitRunner.class)
public class CurrentAreaServiceImplTest {

	CurrentArea currentArea;
	
	@Mock
	CurrentAreaRepository currentAreaRepository;
	
	@InjectMocks
	CurrentAreaServiceImpl currentAreaService;
	
	@Before
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void getAllAreasTest() {
		//
        // GIVEN
        //
		List<CurrentArea> currentAreas = new ArrayList<>();
		currentAreaRepository.findAll().forEach(currentAreas::add);
		//
	    // WHEN
	    //
		List<CurrentArea> currentAreaList = currentAreaService.getAllAreas();
		 //
        // THEN
        //
		Assert.assertEquals(currentAreaList, currentAreas);
	}
	
	@Test 
	public void addAreaTest(CurrentArea currentArea) {
		//
        // GIVEN
        //
		
		//
	    // WHEN
	    //
		
		//
        // THEN
        //
	}
}
