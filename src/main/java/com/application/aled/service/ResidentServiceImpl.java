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

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Service
public class ResidentServiceImpl implements ResidentService {

	
	@Autowired
	ResidentRepository residentRepository;

	@Override
	public Residents getResidentByUser(User user) {
		return residentRepository.findByUser(user);
	}

}
