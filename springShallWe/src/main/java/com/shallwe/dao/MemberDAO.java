package com.shallwe.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.MemberVO;

@Repository
public class MemberDAO implements MemberDAOInterface{
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace="com.shallwe.member.";

	// 회원가입
	public int insertMember(MemberVO member) {
		return sqlsession.insert(namespace + "insertMember", member);
	}

	// 로그인체크
	public MemberVO loginChk(String memberid, String memberpw) {
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("id", memberid);
		loginInfo.put("pw", memberpw);
		return sqlsession.selectOne(namespace + "loginChk", loginInfo);
	}

	// 아이디체크
	public MemberVO idChk(String memberid) {
		return sqlsession.selectOne(namespace + "idChk", memberid);
	}
}
