package com.shallwe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.HotplaceVO;

@Repository
public class HotplaceDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace="com.shallwe.hotplace.";

	//모든 핫플레이스 목록 Select
	public List<HotplaceVO> selectHotplaceLocation() {
		return sqlsession.selectList(namespace + "selectHotplaceLocation");
	}

	// 각 핫플레이스의 lat,lon select
	public HotplaceVO selectHotplaceLocationByName(String hotplaceName) {
		return sqlsession.selectOne(namespace + "selectHotplaceLocationByName", hotplaceName);
	}

}
