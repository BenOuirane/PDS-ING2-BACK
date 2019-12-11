package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.Position;



public interface PositionService {

	public List<Position> getAllPositions();
	Position getPosition(String id);
	void addPosition(Position idPos);
	void updatePosition(Position idPos);
	void removePosition(Position idPos);

}
