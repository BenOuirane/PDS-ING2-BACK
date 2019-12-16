/**
 * 
 */
package com.application.aled.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Bracelet;
import com.application.aled.repository.BraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class BraceletServiceImpl implements BraceletService {
	@Autowired
	BraceletRepository braceletRepository;

	@Override
	public List<Bracelet> getAllBracelets() {
		List<Bracelet> idbraceletlist = new ArrayList<Bracelet>();

		braceletRepository.findAll().forEach(idbraceletlist::add);
		return idbraceletlist;
	}

	@Override
	public void addBracelet(Bracelet idBrac) {
		if (idBrac == null) {
		/*	idBrac = new Bracelet();
			idBrac.setId("Bracelet1_" + System.currentTimeMillis());
			idBrac.setIdResident("AK");
			idBrac.setLastSentData(LocalDateTime.now());
			idBrac.setRefBracelet("Fitbit01");*/
					
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(idBrac);

	}
	
		

	@Override
	public void updateBracelet(Bracelet idBrac) {
		if (idBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(idBrac);

	}


	@Override
	public void removeBracelet(Bracelet idBrac) {
		braceletRepository.delete(idBrac);
		
	}

}
