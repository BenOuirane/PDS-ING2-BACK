/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.ReferentialPositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class ReferentialPositionServiceImpl implements ReferentialPositionService {
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

			return;
		}
		referentialPositionRepository.save(refPosi);

	}

	@Override
	public void updatePositionRef(ReferentialPosition refPosi) {
		if (refPosi == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialPositionRepository.save(refPosi);

	}

	@Override
	public void removePositionRef(ReferentialPosition refPosi) {
		referentialPositionRepository.delete(refPosi);
	}

}
