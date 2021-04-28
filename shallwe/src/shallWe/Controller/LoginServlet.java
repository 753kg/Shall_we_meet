package shallWe.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shallWe.DAO.MemberDAO;
import shallWe.Service.MemberService;
import shallWe.VO.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		
		MemberService service = new MemberService();
		MemberVO m = service.loginChk(memberid, memberpw);
		
		HttpSession session = request.getSession();
		session.setAttribute("memberid", m.getMember_id());
		session.setAttribute("membername", m.getName());
		
		response.sendRedirect("../mainView/main.jsp");
	}

}
