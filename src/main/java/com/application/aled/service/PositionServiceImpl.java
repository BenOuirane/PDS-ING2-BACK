/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Position;
import com.application.aled.repository.PositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository positionRepository;

	@Override
	public List<Position> getAllPositions() {
		// TODO Auto-generated method stub
		List<Position> listPosition = new ArrayList<Position>();
		Iterable<Position> itPos = positionRepository.findAll();

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
		//positionRepository.save(new Position("CUS1",1.250, 25.55,"Cuisine1",2016.11.16.06.43.19));
		

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

	@Override
	public Position getPosition(String id) {
	return null;
	//return positionRepository.findById(id);
	}
}
