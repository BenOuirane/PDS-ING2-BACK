/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.ReferentialBracelet;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public interface ReferentialBraceletService {
	public List<ReferentialBracelet> getAllReferentialBracelets();
	
	 void addBraceletRef(ReferentialBracelet refBrac); 
	 void updateBraceletRef(ReferentialBracelet refBrac);
	 void removeBraceletRef(ReferentialBracelet refBrac);
}
