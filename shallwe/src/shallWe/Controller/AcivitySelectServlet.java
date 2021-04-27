package shallWe.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.ActivityService;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.RestaurantVO;

/**
 * Servlet implementation class AcivitySelect �ȳ�dd�ƿ�
 */
@WebServlet("/makeplan/AcivitySelect")
public class AcivitySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location_name = request.getParameter("location_name");
		
		ActivityService service = new ActivityService();
		List<RestaurantVO> rlist = service.selectRestaurantByLocationName(location_name);
		List<CafeVO> clist = service.selectCafeByLocationName(location_name);
		List<ActivityVO> alist = service.selectActivityByLocationName(location_name);
		request.setAttribute("rlist", rlist);
		request.setAttribute("clist", clist);
		request.setAttribute("alist", alist);

		request.setAttribute("location_name", location_name);
		RequestDispatcher rd = request.getRequestDispatcher("retrieveActivityMain.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
