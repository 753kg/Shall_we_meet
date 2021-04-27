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

import shallWe.Service.DateSelect;
import shallWe.Util.ConvertUtil;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

@WebServlet("/date/memberSelectDate")
public class DateSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DateSelectServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
	}
//	request.setAttribute("dlist", service.selectAllMembers(null));
	//	RequestDispatcher rd = request.getRequestDispatcher("memberSelectDate.jsp");
	//	rd.forward(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력값을 받아서 DB에 저장한다.
		String member_id = request.getParameter("member_id");
		int plan_id = ConvertUtil.covertInt(request.getParameter("plan_id")); //planid를 입력이 아니라 불러와야 한다.
		Date date = ConvertUtil.covertDate(request.getParameter("date"));
		
		DateVO dateVo = new DateVO(member_id, plan_id, date);
		DateSelect service = new DateSelect();
		try {
			List<MemberPlanVO> list = service.selectAllMembers(plan_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
