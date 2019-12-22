package com.application.aled.service;

import java.util.List;


import com.application.aled.entity.CurrentLocation;


public interface CurrentLocationService {
	
	public List<CurrentLocation> getAllLocation();
	
	public CurrentLocation getLocationById(int idlocation);

	void addLocation(CurrentLocation idlocation);

	void updateLocation(CurrentLocation idlocation);

	void removeLocation(CurrentLocation idlocation);
}