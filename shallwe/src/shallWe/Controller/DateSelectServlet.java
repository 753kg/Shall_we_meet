package shallWe.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.DateService;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

/**
 * Servlet implementation class DateSelect
 */
@WebServlet("/date/memberSelectDate")
public class DateSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DateSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력값을 받아서 DB에 저장한다.
		String member_id = request.getParameter("member_id");
		String date = request.getParameter("date");
		int plan_id = convertInt(request.getParameter("plan_id"));
		
		SimpleDateFormat tf = new SimpleDateFormat();
		Date to = tf.parse(date);
		
		DateVO dateVo = new DateVO(member_id, date, plan_id);
		DateService service = new DateService();
		List<MemberPlanVO> list = service.selectAllMembers(plan_id);
	//	request.setAttribute("dlist", service.selectAllMembers(null));
	//	RequestDispatcher rd = request.getRequestDispatcher("memberSelectDate.jsp");
	//	rd.forward(request, response);
	}
	
	private int convertInt(String param) {
		if(param==null || param.trim() =="") return 0;
		return Integer.parseInt(param);
	}

}
