package com.shallwe.dao;

import com.shallwe.model.MemberVO;

public interface MemberDAOInterface {
	
	public int insertMember(MemberVO member);
	public MemberVO loginChk(String memberid, String memberpw);
	public MemberVO idChk(String memberid);
	
}
