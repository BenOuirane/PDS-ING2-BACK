/**
 * 
 */
package com.application.aled.service.referential.bracelet;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialBracelet;
import com.application.aled.repository.ReferentialBraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Service
public class ReferentialBraceletServiceImpl implements ReferentialBraceletService {

	@Autowired
	private ReferentialBraceletRepository referentialBraceletRepository;

	@Override
	public List<ReferentialBracelet> getAllReferentialBracelets() {
		List<ReferentialBracelet> refbraceletlist = new ArrayList<ReferentialBracelet>();

		referentialBraceletRepository.findAll().forEach(refbraceletlist::add);
		return refbraceletlist;
	}

	@Override
	public void addBraceletRef(ReferentialBracelet refBrac) {
		if (refBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialBraceletRepository.save(refBrac);

	}

	@Override
	public void updateBraceletRef(ReferentialBracelet refBrac) {
		if (refBrac == null) {
			
			// FIXME: action non autorisee
			return;
		}
		referentialBraceletRepository.save(refBrac);

	}

	@Override
	public void removeBraceletRef(ReferentialBracelet refBrac) {
		referentialBraceletRepository.delete(refBrac);

	}

}
