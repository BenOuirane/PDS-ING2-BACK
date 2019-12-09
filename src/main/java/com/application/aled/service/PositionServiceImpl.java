/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.Position;
import com.application.aled.repository.PositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository positionRepository;

	@Override
	public List<Position> getAllPositions() {
		// TODO Auto-generated method stub
		List<Position> listPosition = new ArrayList<Position>();
		Iterable<Position> itPos = repository.findAll();

		itPos.forEach(p -> {
			listPosition.add(p);
		});

		return listPosition;
	}

	@Override
	public void addPosition(Position idPos) {
		if (idPos == null) {
			// FIXME: action non autorisee

			return;
		}
		positionRepository.save(idPos);

	}

	@Override
	public void updatePosition(Position idPos) {
		if (idPos == null) {
			// FIXME: action non autorisee

			return;
		}
		positionRepository.save(idPos);

	}

	@Override
	public void removePosition(Position idPos) {
		positionRepository.delete(idPos);
		
	}

}
