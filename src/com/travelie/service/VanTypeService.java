package com.travelie.service;

import java.util.List;

import com.travelie.entity.VanType;

public interface VanTypeService {

	
	public List<VanType> getVanTypes();

	public void saveVanType(VanType theVanType);

	public VanType getVanType(int theId);

	public void deleteVanType(int theId);


	
}
