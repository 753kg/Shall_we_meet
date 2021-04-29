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
import shallWe.VO.DateVO;

@WebServlet("/memberDateList")
public class MemberDateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDateList() {
        super();
        // TODO Auto-generated constructor stub
    }
    //방장이 멤버가 선택한 날짜들 중에서 날짜를 고르는 페이지로 넘기는곳
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateSelect service = new DateSelect();
		try {
			List<DateVO> dlist = service.selectAllDates("1","mem1");
			request.setAttribute("mdall", dlist);
			RequestDispatcher rd = 
					request.getRequestDispatcher("date/memberdates_retrieve.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
