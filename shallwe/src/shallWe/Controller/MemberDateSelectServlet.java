package shallWe.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import shallWe.Service.DateSelect;
import shallWe.Util.ConvertUtil;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

@WebServlet("/memberSelectDate")
public class MemberDateSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDateSelectServlet() {
        super();
    }
    //멤버가 고른 날짜들을 DB에 넘긴다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
    	
    	String memberdates = request.getParameter("dates");
    	String plan_id = request.getParameter("plan_id");
    	HttpSession session = request.getSession();
    	String member_id = (String) session.getAttribute("memberid");
    	System.out.println("=================================");
		System.out.println(plan_id);
		System.out.println(member_id);
		System.out.println(memberdates);
		System.out.println("=================================");
		DateSelect service = new DateSelect();

		try {
			request.setAttribute("mlist", service.updateMemberDates(plan_id, member_id, memberdates));
			response.sendRedirect("makeplan/PlanSelectServlet");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
	
