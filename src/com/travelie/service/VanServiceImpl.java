package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.VanDAO;
import com.travelie.entity.Van;

@Service
public class VanServiceImpl implements VanService {

	@Autowired
	private VanDAO VanDAO;
	
	
	
	@Override
	@Transactional
	public List<Van> getVans() {
		
		
		return VanDAO.getVans();
	}



	@Override
	@Transactional
	public void saveVan(Van theVan) {
		
		VanDAO.saveVan(theVan);
		
	}



	@Override
	@Transactional
	public Van getVan(int theId) {
		return VanDAO.getVan(theId);
	}



	@Override
	@Transactional
	public void deleteVan(int theId) {
		VanDAO.deleteVan(theId);
		
	}

}
