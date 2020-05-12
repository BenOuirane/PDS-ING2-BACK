/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import com.application.aled.entity.Bracelet;
import com.application.aled.repository.BraceletRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BraceletServiceImplTest {

	Bracelet bracelet;
	@Mock
	BraceletRepository braceletRepository;


	@InjectMocks
	BraceletServiceImpl braceletService;
	
	@Before
	public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }
	
	@Test
	public void getAllBraceletsTest() {
		//
        // GIVEN
        //
		List<Bracelet> bracelets = new ArrayList<>();
		braceletRepository.findAll().forEach(bracelets::add);
		//
	    // WHEN
	    //
		List<Bracelet> braceletList = braceletService.getAllBracelets();
		 //
        // THEN
        //
		Assert.assertEquals(braceletList, bracelets);
	}
	
	/*@Test
	public void addBraceletTest(Bracelet idBracelet) {
		//
        // GIVEN
        //
		
		//
	    // WHEN
	    //
		
		 //
        // THEN
        //
	}*/
}
