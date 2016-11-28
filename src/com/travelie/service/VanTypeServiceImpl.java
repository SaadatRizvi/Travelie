package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.VanTypeDAO;
import com.travelie.entity.VanType;

@Service
public class VanTypeServiceImpl implements VanTypeService {

	@Autowired
	private VanTypeDAO vanTypeDAO;
	
	
	
	@Override
	@Transactional
	public List<VanType> getVanTypes() {
		
		
		return vanTypeDAO.getVanTypes();
	}



	@Override
	@Transactional
	public void saveVanType(VanType theVanType) {
		
		vanTypeDAO.saveVanType(theVanType);
		
	}



	@Override
	@Transactional
	public VanType getVanType(int theId) {
		return vanTypeDAO.getVanType(theId);
	}



	@Override
	@Transactional
	public void deleteVanType(int theId) {
		vanTypeDAO.deleteVanType(theId);
		
	}

}
