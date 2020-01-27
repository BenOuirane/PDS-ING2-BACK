/**
 * 
 */
package com.application.aled.service;

import java.util.List;


import com.application.aled.entity.ReferentialLocation;


/**
 * @author ISMAIL EL HAMMOUD
 *
 */

public interface LocationService {

	public List<ReferentialLocation> getAllLocation();
	public ReferentialLocation getLocationById(int idloc);
	void   addLocation(ReferentialLocation idloc);

	void updateLocation(ReferentialLocation idloc);

	void removeLocation(ReferentialLocation idloc);
}
