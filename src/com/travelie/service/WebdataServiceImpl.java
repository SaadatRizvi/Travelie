package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.WebdataDAO;
import com.travelie.entity.Webdata;

@Service
public class WebdataServiceImpl implements WebdataService {

	@Autowired
	private WebdataDAO webdataDAO;
	
	
	
	@Override
	@Transactional
	public List<Webdata> getWebdatas() {
		
		
		return webdataDAO.getWebdatas();
	}



	@Override
	@Transactional
	public void saveWebdata(Webdata theWebdata) {
		
		webdataDAO.saveWebdata(theWebdata);
		
	}



	@Override
	@Transactional
	public Webdata getWebdata(int theId) {
		return webdataDAO.getWebdata(theId);
	}



	@Override
	@Transactional
	public void deleteWebdata(int theId) {
		webdataDAO.deleteWebdata(theId);
		
	}

}
