package com.application.aled.service;
import com.application.aled.entity.Resident;
import com.application.aled.entity.Rooms;
import com.application.aled.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.aled.repository.ResidentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;


@Service
public class ResidentServiceImpl implements ResidentService {

	
	@Autowired
	ResidentRepository residentRepository;

	Logger logger = Logger.getLogger("com.application.aled.service.ResidentServiceImpl");

	@Override
	@Transactional
	public Resident getResidentByUser(User user) {
		Resident _resident = residentRepository.findByUser(user);
		logger.info("getResidentByUser" + _resident.toString());
		return _resident;
	}

	public Resident getResidentByRoom(Rooms room){
		Resident resident = residentRepository.findByRoom(room);
		logger.info("getResidentByRoom" + resident.toString());
		return resident;
	}
	
	@Override
	@Transactional
	public List<Resident> getAllResidents(){

		 return this.residentRepository.findAll();
	}

	@Override
	public Resident getResidentById(Long id) {

		return this.residentRepository.findById(id).get();
	}

}

