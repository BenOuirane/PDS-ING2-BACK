/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.CBracelet;
import com.application.aled.repository.CBraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class CBraceletServiceImpl implements CBraceletService {

	@Autowired
	CBraceletRepository cbraceletRepository;
	@Override
	public List<CBracelet> getAllBracelet() {
		List<CBracelet> cbraceletlist = new ArrayList<CBracelet>();

		cbraceletRepository.findAll().forEach(cbraceletlist::add);
		return cbraceletlist;
	}

	@Override
	public void addBracelet(CBracelet idbracelet) {
		if (idbracelet == null) {
			// FIXME: action non autorisee
			//logger.error("Cannot add this position to referential positions");
			//logger.info("Adding operation is failed");
			return;
		}
		cbraceletRepository.save(idbracelet);
	//	logger.info("A position was added to the referential" + refPosi);


	}

	@Override
	public void updateBracelet(CBracelet idbracelet) {
		if (idbracelet == null) {
			// FIXME: action non autorisee
		//	logger.error("Cannot update this position to referential positions ");
		//	logger.info("Updating operation is failed" );
			return;
		}
		cbraceletRepository.save(idbracelet);
		// logger.info("A position was updated in the referential" + refPosi);

	}

	@Override
	public void removeBracelet(CBracelet idbracelet) {
		// TODO Auto-generated method stub
		cbraceletRepository.delete(idbracelet);
	}


}
