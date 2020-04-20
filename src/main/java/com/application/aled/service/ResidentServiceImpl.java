/**
 *
 */
package com.application.aled.service;

import com.application.aled.entity.Resident;
import com.application.aled.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.repository.ResidentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "resident_service")
public class ResidentServiceImpl implements ResidentService {


	@Autowired
	ResidentRepository residentRepository;

	@Override
	@Transactional
	public Resident getResidentByUser(User user) {
		Resident _resident = residentRepository.findByUser(user);
		System.out.println("getResidentByUser" + _resident.toString());
		return _resident;
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
