/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialLocation;
import com.application.aled.entity.Position;
import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.LocationRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class LocationServiceImpl implements LocationService {
	
	//static final Logger logger = LogManager.getLogger(ReferentialPositionController.class.getName());

	@Autowired
	LocationRepository locationRepository;

	@Override
	public List<ReferentialLocation> getAllLocation() {
		List<ReferentialLocation> locationlist = new ArrayList<ReferentialLocation>();

		locationRepository.findAll().forEach(locationlist::add);
		return locationlist;
	
	}

	@Override
	public void addLocation(ReferentialLocation idloc) {
		if (idloc == null) {
			// FIXME: action non autorisee
			//logger.error("Cannot add this position to referential positions");
			//logger.info("Adding operation is failed");
			return;
		}
		locationRepository.save(idloc);
	//	logger.info("A position was added to the referential" + refPosi);

		
	}

	@Override
	public void updateLocation(ReferentialLocation idloc) {
		if (idloc == null) {
			// FIXME: action non autorisee
		//	logger.error("Cannot update this position to referential positions ");
		//	logger.info("Updating operation is failed" );
			return;
		}
		locationRepository.save(idloc);
		// logger.info("A position was updated in the referential" + refPosi);

	}
	
	@Override
	public void removeLocation(ReferentialLocation idloc) {
		locationRepository.delete(idloc);
		//	logger.info("A position was deleted from the referential" + refPosi);

		}

	@Override
	public ReferentialLocation getLocationById(int idloc) {
		System.out.println("Getting position...");
		ReferentialLocation loc = locationRepository.findById(idloc).get();
		return loc;
	}

	}
