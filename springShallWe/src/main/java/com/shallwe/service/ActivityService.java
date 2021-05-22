package com.shallwe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallwe.dao.ActivityDAO;
import com.shallwe.model.ActivityVO;
import com.shallwe.model.CafeVO;
import com.shallwe.model.RestaurantVO;
import com.shallwe.model.SafetyRestaurantVO;

@Service
public class ActivityService {
	
	@Autowired
	ActivityDAO dao;
	
	public int countRestByLoc(String location_name) {
		return dao.countRestByLoc(location_name);
	}
	
	public int countCafeByLoc(String location_name) {
		return dao.countCafeByLoc(location_name);
	}
	
	public int countActByLoc(String location_name) {
		return dao.countActByLoc(location_name);
	}
	
	public int countSafetyByLoc(String location_name) {
		return dao.countSafetyByLoc(location_name);
	}
	
	// 페이징
	public List<RestaurantVO> selectRestByLoc(String location_name,int startNum, int endNum) {
		return dao.selectRestByLoc(location_name, startNum, endNum);
	}
	
	public List<CafeVO> selectCafeByLoc(String location_name, int startNum, int endNum) {
		return dao.selectCafeByLoc(location_name, startNum, endNum);
	}
	
	public List<ActivityVO> selectActByLoc(String location_name, int startNum, int endNum) {
		return dao.selectActByLoc(location_name, startNum, endNum);
	}
	
	public List<SafetyRestaurantVO> selectSafetyByLoc(String location_name, int startNum, int endNum) {
		return dao.selectSafetyByLoc(location_name, startNum, endNum);
	}
}
