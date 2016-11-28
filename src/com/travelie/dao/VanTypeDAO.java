package com.travelie.dao;

import java.util.List;

import com.travelie.entity.VanType;

public interface VanTypeDAO {

	public List<VanType> getVanTypes();

	public void saveVanType(VanType theVanType);

	public VanType getVanType(int theId);

	public void deleteVanType(int theId);
	
}
