package com.shallwe.service;

import com.shallwe.model.MemberVO;

public interface MemberServiceInterface {

	public int insertMember(MemberVO member);
	public MemberVO loginChk(String memberid, String memberpw);
	public MemberVO idChk(String memberid);
	
}
