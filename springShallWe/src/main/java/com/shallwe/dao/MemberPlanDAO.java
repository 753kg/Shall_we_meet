package com.shallwe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.MemberLocationVO;
import com.shallwe.model.MemberPlanVO;

@Repository
public class MemberPlanDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace="com.shallwe.memberplan.";

	// �� ����� lat,lon �ֱ�
	public int updateMemberLocation(MemberPlanVO mpvo) {
		return sqlsession.update(namespace + "updateMemberLocation", mpvo);
	}
	
	//������̵�� �÷� ���̵�� �� ����� lat,lon Select
	public double[] selectMemberLocation(String plan_id,String member_id) {
		Map<String, String> map = new HashMap<>();
		map.put("member_id", member_id);
		map.put("plan_id", plan_id);
		MemberLocationVO mloc = sqlsession.selectOne(namespace + "selectMemberLocation", map);
		double[] member_location = new double[2];
		member_location[0]=mloc.getLat();
		member_location[1]=mloc.getLon();
		return member_location;
	}
	

	// �׷� ������� lat,lon select
	public List<MemberPlanVO> selectLocationByGroup(String plan_id) {
		return sqlsession.selectList(namespace + "selectLocationByGroup", plan_id);
	}

	// ȣ��Ʈ�� ��� ��ġ�� �� ���� , ȣ��Ʈ�� �ƴѰ�� ���� �浵�� 0 ����
	public int insertMemberPlan(String plan_id, String member_id, double lat, double lon) {
		Map<String, Object> map = new HashMap<>();
		map.put("member_id", member_id);
		map.put("plan_id", plan_id);
		map.put("lat", lat);
		map.put("lon", lon);
		return sqlsession.insert(namespace + "insertMemberPlan", map);

	}

}
