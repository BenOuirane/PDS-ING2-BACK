/**
 *
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.application.aled.entity.Area;
import com.application.aled.repository.AreaRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AreaServiceImplTest {

	Area area;

	@Mock
	AreaRepository areaRepository;

	@InjectMocks
	AreaServiceImpl areaService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllAreasTest() {
		//
		// GIVEN
		//
		List<Area> areas = new ArrayList<>();
		areaRepository.findAll().forEach(areas::add);
		//
		// WHEN
		//
		List<Area> areaList = areaService.getAllAreas();
		//
		// THEN
		//
		Assert.assertEquals(areaList, areas);
	}


}
