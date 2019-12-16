/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.Resident;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

public interface ResidentService {
	public List<Resident> getAllResidents();

	void addResident(Resident idResi);

	void updateResident(Resident idResi);

	void removeResident(Resident idResi);
}
