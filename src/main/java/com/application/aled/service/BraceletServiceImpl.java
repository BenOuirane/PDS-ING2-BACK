/**
 * 
 */
package com.application.aled.service;
import java.util.ArrayList;
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
	BraceletRepository braceletObjrepository;

	@Override
	public List<Bracelet> getAllBracelets() {
		List<Bracelet> idbraceletlist = new ArrayList<Bracelet>();

		braceletObjrepository.findAll().forEach(idbraceletlist::add);
		return idbraceletlist;
	}

	@Override
	public void addBracelet(Bracelet idBrac) {
		if (idBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletObjrepository.save(idBrac);

	}
		

	@Override
	public void updateBracelet(Bracelet idBrac) {
		if (idBrac == null) {
			// FIXME: action non autorisee
			return;
		}
		braceletObjrepository.save(idBrac);

	}


	@Override
	public void removeBracelet(Bracelet idBrac) {
		braceletObjrepository.delete(idBrac);
		
	}

}
