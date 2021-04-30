package shallWe.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.DAO.MemberDAO;
import shallWe.Service.MemberService;
import shallWe.VO.MemberVO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String register_id = request.getParameter("register_id");
		String register_pw = request.getParameter("register_pw");
		String register_name = request.getParameter("register_name");
		String register_email = request.getParameter("register_email");
		String register_phone = request.getParameter("register_phone");
		String register_security = request.getParameter("register_security");
		
		MemberVO new_mem = new MemberVO();
		new_mem.setMember_id(register_id);
		new_mem.setPassword(register_pw);
		new_mem.setName(register_name);
		new_mem.setEmail(register_email);
		new_mem.setPhone_number(register_phone);
		new_mem.setSecurity(register_security);
		
		MemberService service = new MemberService();
		int result = service.insertMember(new_mem);
		String message = "회원가입 성공";
		if(result == 0) {
			message = "회원가입 실패";
		}
		System.out.println(message);
		response.sendRedirect("../mainView/main.jsp");
	}

}
