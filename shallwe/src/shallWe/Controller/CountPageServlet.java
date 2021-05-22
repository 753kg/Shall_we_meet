package shallWe.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.ActivityService;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.RestaurantVO;
import shallWe.VO.SafetyRestaurantVO;

/**
 * Servlet implementation class CountPageServlet
 */
@WebServlet("/activityView/CountPage")
public class CountPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location_name = request.getParameter("location_name");
		String type = request.getParameter("type");
		
		ActivityService service = new ActivityService();
		int displayData = 5;
		int totalData = 0;
		int totalPage = 0;
		switch (type) {
		case "r":
			totalData = service.countRestByLoc(location_name);
			totalPage = calTotalPage(totalData, displayData);
			break;
		case "c":
			totalData = service.countCafeByLoc(location_name);
			totalPage = calTotalPage(totalData, displayData);
			break;
		case "a":
			totalData = service.countActByLoc(location_name);
			totalPage = calTotalPage(totalData, displayData);
			break;
		case "s":
			totalData = service.countSafetyByLoc(location_name);
			totalPage = calTotalPage(totalData, displayData);
			break;
		default:
			break;
		}
		PrintWriter out = response.getWriter();
		out.print(totalPage);
	}
	
	private static int calTotalPage(int totalData, int displayData) {
		int totalPage = 0;
		totalPage = totalData / displayData;
		if(totalData % displayData > 0) totalPage++;
		return totalPage;
	}
}
