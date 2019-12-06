package com.application.aled.service;

import java.util.List;
import com.application.aled.entity.MedObject;
import com.application.aled.entity.ReferentialResident;

public interface MedObjectService {
	public List<MedObject> getAllMedObject();
	
	void addMedObject(MedObject medObj);
	void updateMedObject(MedObject medObj);
	void removeMedObject(MedObject medObj);

}
