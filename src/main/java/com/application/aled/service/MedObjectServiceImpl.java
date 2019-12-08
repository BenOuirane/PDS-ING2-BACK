/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.MedObject;
import com.application.aled.repository.MedObjectRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class MedObjectServiceImpl implements MedObjectService {
	@Autowired
	MedObjectRepository repository;

	@Override
	public List<MedObject> getAllMedObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
