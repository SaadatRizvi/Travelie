package com.travelie.service;

import java.util.List;

import com.travelie.entity.Van;

public interface VanService {

	
	public List<Van> getVans();

	public void saveVan(Van theVan);

	public Van getVan(int theId);

	public void deleteVan(int theId);


	
}
