package shallWe.Controller;

import java.io.IOException;
import java.util.Arrays;
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

import com.google.gson.Gson;

/**
 * Servlet implementation class AcivitySelect �ȳ�dd�ƿ�
 */
@WebServlet("/makeplan/AcivitySelect")
public class AcivitySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location_name = request.getParameter("location_name");
		
		request.setAttribute("location_name", location_name);
		
		RequestDispatcher rd = request.getRequestDispatcher("paginationTest.jsp");
		rd.forward(request, response);
	}
}
