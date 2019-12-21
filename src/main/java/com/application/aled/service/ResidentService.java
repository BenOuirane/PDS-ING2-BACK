/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.User;

import com.application.aled.entity.Residents;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

public interface ResidentService {
	public List<Residents> getAllResidents();

	void addResident(Residents idResi);

	void updateResident(Residents idResi);

	void removeResident(Residents idResi);

	public Residents getResidentByUser(User user);
}
