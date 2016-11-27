package com.travelie.service;

import java.util.List;

import com.travelie.entity.Webdata;

public interface WebdataService {

	
	public List<Webdata> getWebdatas();

	public void saveWebdata(Webdata theWebdata);

	public Webdata getWebdata(int theId);

	public void deleteWebdata(int theId);


	
}
