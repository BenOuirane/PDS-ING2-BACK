/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.application.aled.entity.ReferentialBracelet;
import com.application.aled.repository.ReferentialBraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class ReferentialBraceletServiceImpl implements ReferentialBraceletService {

	@Autowired
	private ReferentialBraceletRepository braceletRepository;

	@Override
	public List<ReferentialBracelet> getAllReferentialBracelets() {
		List<ReferentialBracelet> refbraceletlist = new ArrayList<ReferentialBracelet>();

		braceletRepository.findAll().forEach(refbraceletlist::add);
		return refbraceletlist;
	}

	@Override
	public void addBraceletRef(ReferentialBracelet refBrac) {
		if (refBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(refBrac);

	}

	@Override
	public void updateBraceletRef(ReferentialBracelet refBrac) {
		if (refBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(refBrac);

	}

	@Override
	public void removeBraceletRef(ReferentialBracelet refBrac) {
		braceletRepository.delete(refBrac);

	}

}
