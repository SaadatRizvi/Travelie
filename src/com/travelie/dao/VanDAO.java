package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Van;

public interface VanDAO {

	public List<Van> getVans();

	public void saveVan(Van theVan);

	public Van getVan(int theId);

	public void deleteVan(int theId);
	
}