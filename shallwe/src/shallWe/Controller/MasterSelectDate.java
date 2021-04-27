package shallWe.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.DAO.DateDAO;
import shallWe.Service.DateSelect;
import shallWe.Util.ConvertUtil;
import shallWe.VO.DateOptionVO;

@WebServlet("/date/masterSelectDate")
public class MasterSelectDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterSelectDate() {
        super();
    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateOptionVO dovo = new DateOptionVO();
		dovo.setHost_date(ConvertUtil.covertDate(request.getParameter("host_date")));
		
		DateSelect service = new DateSelect();
		try {
			int result = service.updateMasterDate(dovo);
			String message = result > 0 ?"날짜 선택 완료":"날짜 선택 실패";
			request.setAttribute("message", message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	String obj = request.getParameter("plan_id");
//	if(obj == null) throw new ServletException("약속이 없습니다.");
	
//	int planid = Integer.parseInt(obj);
//	DateSelect service = new DateSelect();
//	request.setAttribute("plan_id", service.selectMemIdplanId(planid));
	
//	RequestDispatcher rd = request.getRequestDispatcher("masterSelectDate.jsp");
//	rd.forward(request, response);

}
