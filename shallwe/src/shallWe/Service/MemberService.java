package shallWe.Service;

import shallWe.DAO.MemberDAO;
import shallWe.VO.MemberVO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	public int insertMember(MemberVO m) {
		return dao.insertMember(m);
	}
	
	public MemberVO loginChk(String memberid, String memberpw) {
		return dao.loginChk(memberid, memberpw);
	}
	
	public MemberVO IDChk(String memberid) {
		return dao.IDChk(memberid);
	}
}
