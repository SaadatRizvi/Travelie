package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.controller.HomepageController;
import com.travelie.dao.VanDAO;
import com.travelie.entity.Van;

@Service
public class VanServiceImpl implements VanService {

	private static Logger logger = Logger
			.getLogger(VanServiceImpl.class);
	
	
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



	@Override
	public List<Van> getAvailableVans() {
		logger.info("vanmethod(): 1 ");
		List <Van> vans = VanDAO.getVans();
		logger.info("vanmethod(): 2 ");
		List<Van> availableVans = new ArrayList<Van>();
		
		for (Van temp: vans){
			
			if (temp.getFlagged()==0){
				logger.info("vanmethod(): 3000 ");
				availableVans.add(temp);
			}
		}
		logger.info("vanmethod(): 31 ");
		return availableVans;
	}

}
