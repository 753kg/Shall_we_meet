package com.shallwe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.ActivityVO;
import com.shallwe.model.CafeVO;
import com.shallwe.model.RestaurantVO;
import com.shallwe.model.SafetyRestaurantVO;

@Repository
public class ActivityDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace = "com.shallwe.activity.";
	
	public List<RestaurantVO> selectRestByLoc(String location_name, int startNum, int endNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("location_name", location_name);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlsession.selectList(namespace + "selectRestByLoc", map);
	}
	
	public List<CafeVO> selectCafeByLoc(String location_name, int startNum, int endNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("location_name", location_name);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlsession.selectList(namespace + "selectCafeByLoc", map);
	}
	
	public List<ActivityVO> selectActByLoc(String location_name, int startNum, int endNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("location_name", location_name);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlsession.selectList(namespace + "selectActByLoc", map);
	}
	
	public List<SafetyRestaurantVO> selectSafetyByLoc(String location_name, int startNum, int endNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("location_name", location_name);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlsession.selectList(namespace + "selectSafetyByLoc", map);
	}
	
	public int countRestByLoc(String location_name) {
		return sqlsession.selectOne(namespace + "countRestByLoc", location_name);
	}
	
	public int countCafeByLoc(String location_name) {
		return sqlsession.selectOne(namespace + "countCafeByLoc", location_name);
	}
	
	public int countActByLoc(String location_name) {
		return sqlsession.selectOne(namespace + "countActByLoc", location_name);
	}
	
	public int countSafetyByLoc(String location_name) {
		return sqlsession.selectOne(namespace + "countSafetyByLoc", location_name);
	}
	
}
