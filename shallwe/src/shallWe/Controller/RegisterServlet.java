package shallWe.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.VO.MemberVO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String register_id = (String) request.getAttribute("register_id");
		String register_pw = (String) request.getAttribute("register_pw");
		String register_name = (String) request.getAttribute("register_name");
		String register_email = (String) request.getAttribute("register_email");
		String register_phone = (String) request.getAttribute("register_phone");
		String register_security = (String) request.getAttribute("register_security");
		
		MemberVO new_mem = new MemberVO();
	}

}
