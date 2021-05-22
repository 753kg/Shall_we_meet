package shallWe.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		
		MemberService service = new MemberService();
		MemberVO m = service.loginChk(memberid, memberpw);
		PrintWriter out = response.getWriter();
		
		
		if(m == null) {
			out.print(0);	// 일치하는 회원이 없음
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("memberid", m.getMember_id());
			session.setAttribute("membername", m.getName());
			out.print(1);
			
			//response.sendRedirect("../mainView/main.jsp");
		}
		
	}

}
