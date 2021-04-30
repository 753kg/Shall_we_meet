package shallWe.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.DateSelect;

@WebServlet("/masterFixDate")
public class MasterFixDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterFixDateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fixdate = request.getParameter("dates");
		String plan_id = request.getParameter("plan_id");
		System.out.println("MemberDateList>> " + plan_id);
		System.out.println(fixdate);
		DateSelect service = new DateSelect();
		try {
			request.setAttribute("fdate", service.updateFixDate(fixdate, plan_id));
			RequestDispatcher rd = 
					request.getRequestDispatcher("makeplan/PlanSelectServlet");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
