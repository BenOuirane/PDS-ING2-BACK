/**
 * 
 */
package com.application.aled.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Bracelet;
import com.application.aled.repository.BraceletRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class BraceletServiceImpl implements BraceletService {
	
	@Autowired
	BraceletRepository braceletRepository;

	@Override
	public List<Bracelet> getAllBracelets() {
		List<Bracelet> idbraceletlist = new ArrayList<Bracelet>();
		braceletRepository.findAll().forEach(idbraceletlist::add);
		
		return idbraceletlist;
	}
	
	@Override
	public void addBracelet(Bracelet idBrac) {
		if (idBrac == null) {
		/*	idBrac = new Bracelet();
			idBrac.setId("Bracelet1_" + System.currentTimeMillis());
			idBrac.setIdResident("AK");
			idBrac.setLastSentData(LocalDateTime.now());
			idBrac.setRefBracelet("Fitbit01");*/
					
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(idBrac);

	}

	
	@Override
	public void updateBracelet(Bracelet idBrac) {
		if (idBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletRepository.save(idBrac);

	}

	@Override
	public void removeBracelet(Bracelet idBrac) {
		braceletRepository.delete(idBrac);
		// FIXME: unauthorized action

	}

	@Override
	public Bracelet getBraceletById(Long idBrac) {
		Bracelet bracelet = braceletRepository.findById(idBrac).get();
		return bracelet;
	}

	@Override
	public List<Bracelet> getBraceletByYear(int year) {
		List<Bracelet> braceletsYear = new ArrayList<>();
		braceletRepository.findBraceletByYY(year).forEach(braceletsYear::add);
		return braceletsYear;
	}

	@Override
	public List<Bracelet> getBraceletByYearAndMonth(int year, int month) {
		List<Bracelet> braceletsYYMM = new ArrayList<>();
		braceletRepository.findBraceletByYYMM(year, month).forEach(braceletsYYMM::add);
		return braceletsYYMM;
	}

	@Override
	public List<Bracelet> getBraceletByDay(int year, int month, int day) {
		List<Bracelet> braceletsYYMMDD = new ArrayList<>();
		braceletRepository.findBraceletByYYMMDD(year, month, day).forEach(braceletsYYMMDD::add);
		return braceletsYYMMDD;
	}
	public Bracelet getBraceletByRefBracelet(String name) {
		return this.braceletRepository.findBraceletByRefBracelet(name);
	}


}
