/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialResident;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */


public interface ReferentialResidentService {
	public List<ReferentialResident> getAllReferentialResidents();

	void addResidentRef(ReferentialResident refResi);

	void updateResidentRef(ReferentialResident refResi);

	void removeResidentRef(ReferentialResident refResi);

	public List<ReferentialResident> findByIdResident();
}
