package shallWe.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.DateSelect;
import shallWe.VO.DateOptionVO;

@WebServlet("/masterDateList")
public class MasterDateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterDateList() {
        super();
    }
    //硫ㅻ쾭媛� 諛⑹옣�씠 �꽑�깮�븳 �궇吏쒕뱾 以묒뿉�꽌 怨좊Ⅴ�뒗 �럹�씠吏�濡� �꽆湲곕뒗怨�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plan_id = request.getParameter("plan_id");
		System.out.println(plan_id);
		DateSelect service = new DateSelect();
		try {
			List<DateOptionVO> dolist = service.selectHostDates(plan_id);
			request.setAttribute("hdall", dolist);
			request.setAttribute("plan_id", plan_id);
			RequestDispatcher rd = 
					request.getRequestDispatcher("date/masterdates_retrieve.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
