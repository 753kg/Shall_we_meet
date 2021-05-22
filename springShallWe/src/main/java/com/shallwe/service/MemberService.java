package com.shallwe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallwe.dao.MemberDAOInterface;
import com.shallwe.model.MemberVO;

@Service
public class MemberService implements MemberServiceInterface {
	
	@Autowired
	MemberDAOInterface dao;
	
	@Override
	public int insertMember(MemberVO member) {
		return dao.insertMember(member);
	}

	@Override
	public MemberVO loginChk(String memberid, String memberpw) {
		// TODO Auto-generated method stub
		return dao.loginChk(memberid, memberpw);
	}

	@Override
	public MemberVO idChk(String memberid) {
		// TODO Auto-generated method stub
		return dao.idChk(memberid);
	}
	
	
}
