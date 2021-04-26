package shallWe.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shallWe.DAO.PlanDAO;
import shallWe.VO.PlanVO;

/**
 * Servlet implementation class PlanSelectServlet
 */
@WebServlet("/makeplan/PlanSelectServlet")
public class PlanSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 약속 조회
		PlanDAO dao = new PlanDAO();
		HttpSession session = request.getSession();
		String memberid = (String) session.getAttribute("memberid");
		if(memberid == null) {
			response.sendRedirect("../login/login.jsp");
		}
		else {
			List<PlanVO> planlist = dao.selectPlanByMemberId(memberid);
			request.setAttribute("planlist", planlist);
			RequestDispatcher rd = request.getRequestDispatcher("retrivePlan.jsp");
			rd.forward(request, response);
		}
	}

}
