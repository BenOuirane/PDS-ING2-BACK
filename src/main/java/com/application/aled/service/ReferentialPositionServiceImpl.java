/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.aled.controller.ReferentialPositionController;
import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.ReferentialPositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class ReferentialPositionServiceImpl implements ReferentialPositionService {
	
	//static final Logger logger = LogManager.getLogger(ReferentialPositionController.class.getName());

	@Autowired
	ReferentialPositionRepository referentialPositionRepository;

	@Override
	public List<ReferentialPosition> getAllReferentialPositions() {
		List<ReferentialPosition> refpositionslist = new ArrayList<ReferentialPosition>();

		referentialPositionRepository.findAll().forEach(refpositionslist::add);
		return refpositionslist;
	}

	@Override
	public void addPositionRef(ReferentialPosition refPosi) {
		if (refPosi == null) {
			// FIXME: action non autorisee
			//logger.error("Cannot add this position to referential positions");
			//logger.info("Adding operation is failed");
			return;
		}
		referentialPositionRepository.save(refPosi);
	//	logger.info("A position was added to the referential" + refPosi);


	}

	@Override
	public void updatePositionRef(ReferentialPosition refPosi) {
		if (refPosi == null) {
			// FIXME: action non autorisee
		//	logger.error("Cannot update this position to referential positions ");
		//	logger.info("Updating operation is failed" );
			return;
		}
		referentialPositionRepository.save(refPosi);
		// logger.info("A position was updated in the referential" + refPosi);

	}
	

	@Override
	public void removePositionRef(ReferentialPosition refPosi) {
		referentialPositionRepository.delete(refPosi);
	//	logger.info("A position was deleted from the referential" + refPosi);

	}

	@Override
	public ReferentialPosition getPositionById(int refPosi) {
		System.out.println("Getting the reference of the Resident");
		ReferentialPosition ref = referentialPositionRepository.findById(refPosi).get();
		return ref;
	}
	
	
	

}
