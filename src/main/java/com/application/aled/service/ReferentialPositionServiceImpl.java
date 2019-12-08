/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.ReferentialPositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class ReferentialPositionServiceImpl implements ReferentialPositionService {
	@Autowired
	ReferentialPositionRepository positionsRefRepository;

	@Override
	public List<ReferentialPosition> getAllReferentialPositions() {
		List<ReferentialPosition> refpositionslist = new ArrayList<ReferentialPosition>();

		positionsRefRepository.findAll().forEach(refpositionslist::add);
		return refpositionslist;
	}

	@Override
	public void addPositionRef(ReferentialPosition refPosi) {
		if (refPosi == null) {
			// FIXME: action non autorisee

			return;
		}
		positionsRefRepository.save(refPosi);

	}

	@Override
	public void updateResidentRef(ReferentialPosition refPosi) {
		if (refPosi == null) {
			// FIXME: action non autorisee
			return;
		}
		positionsRefRepository.save(refPosi);

	}

	@Override
	public void removeResidentRef(ReferentialPosition refPosi) {
		positionsRefRepository.delete(refPosi);
	}

}
