/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import com.application.aled.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Residents;
import com.application.aled.repository.ResidentRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ResidentServiceImpl implements ResidentService {

	
	@Autowired
	ResidentRepository residentRepository;

	@Override
	@Transactional
	public Residents getResidentByUser(User user) {
		Residents _resident = residentRepository.findByUser(user);
		System.out.println("getResidentByUser" + _resident.toString());
		return _resident;
	}

}
