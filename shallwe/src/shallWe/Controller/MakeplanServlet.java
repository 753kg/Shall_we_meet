package shallWe.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Makeplan
 */
@WebServlet("/makeplan/Makeplan")
public class MakeplanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("makePlan.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			System.out.println("name: " + name);
			System.out.println("value: " + value);
		}
		// host_id, plan_name, membercount --> plans
		// host_date --> date_options
		// host_id, friends --> members_plans
		
		// members_plans에 insert하려면  plan_id가 필요.
		// plan_id를 어떻게 가져오지..? 
		// 프로시저 써야하나
		/*
		String host_id = (String) request.getParameter("host_id");
		String plan_name = (String) request.getParameter("plan_name");
		String host_date = (String) request.getParameter("host_date");
		String host_place = (String) request.getParameter("host_place");
		String membercount = (String) request.getParameter("membercount");
		
		System.out.println("host_id: " + host_id);
		System.out.println("plan_name: " + plan_name);
		System.out.println("host_date: " + host_date);
		System.out.println("host_place: " + host_place);
		System.out.println("membercount: " + membercount);
		*/
		
		response.sendRedirect("PlanSelectServlet");
	}

}
