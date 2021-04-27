package shallWe.Service;

import shallWe.DAO.MemberDAO;
import shallWe.VO.MemberVO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	public int insertMember(MemberVO m) {
		return dao.insertMember(m);
	}
}
