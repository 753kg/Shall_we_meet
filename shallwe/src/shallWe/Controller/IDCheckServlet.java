package shallWe.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.MemberService;
import shallWe.VO.MemberVO;

/** 회원가입 & 친구초대 시 아이디 중복 체크
 * Servlet implementation class IDCheckServlet
 */
@WebServlet("/login/IDCheck")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String register_id = request.getParameter("register_id");
		
		MemberService service = new MemberService();
		MemberVO register_mem = service.IDChk(register_id);
		System.out.println("idcheck: " + register_mem);
		
		PrintWriter out = response.getWriter();
		if(register_mem == null) {
			out.print(0);	// 중복X
		} else {
			out.print(1);	// 중복O
		}
		
	}


}
