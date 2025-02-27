package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.Resident;
import com.application.aled.entity.Rooms;
import com.application.aled.entity.User;


/**
 * @author ISMAIL EL HAMMOUD
 *
 */

public interface ResidentService {

	public Resident getResidentByUser(User user);
	public List<Resident> getAllResidents();

	Resident getResidentById(Long id);



	public Resident getResidentByRoom(Rooms room);
}
