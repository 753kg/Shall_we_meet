package com.shallwe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallwe.dao.HotplaceDAO;
import com.shallwe.model.HotplaceVO;

@Service
public class HotplaceService {
	
	@Autowired
	HotplaceDAO htdao;

	public List<HotplaceVO> selectHotplaceLocation() {
		return htdao.selectHotplaceLocation();
	}

	public HotplaceVO selectHotplaceLocationByName(String hotplaceName) {
		return htdao.selectHotplaceLocationByName(hotplaceName);
	}
}
