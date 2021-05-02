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

/** �쉶�썝媛��엯 & 移쒓뎄珥덈� �떆 �븘�씠�뵒 以묐났 泥댄겕
 * Servlet implementation class IDCheckServlet
 */
@WebServlet("/login/IDCheck")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		
		MemberService service = new MemberService();
		MemberVO mem = service.IDChk(member_id);
		System.out.println("idcheck: " + mem);
		
		PrintWriter out = response.getWriter();
		if(mem == null) {
			out.print(0);	// 중복X
		} else {
			out.print(1);	// 중복O
		}
	}
}
