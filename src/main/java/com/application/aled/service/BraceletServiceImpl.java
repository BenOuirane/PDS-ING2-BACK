/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.Bracelet;
import com.application.aled.repository.BraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class BraceletServiceImpl implements BraceletService {
	@Autowired
	BraceletRepository repository;

	@Override
	public List<Bracelet> getAllBracelets() {
		// TODO Auto-generated method stub
		return null;
	}

}
