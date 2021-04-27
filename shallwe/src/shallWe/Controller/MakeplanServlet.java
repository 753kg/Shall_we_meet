package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.PlanService;

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
		String host_id = request.getParameter("host_id");
		String plan_name = request.getParameter("plan_name");
		int numbers = Integer.parseInt(request.getParameter("membercount"));
		String host_date = request.getParameter("host_date");
		String host_place = request.getParameter("host_place");
		
		String plan_id = host_id + System.currentTimeMillis();
		
		List<String> friend_id_list = new ArrayList<>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.substring(0, 1).equals("f")) {
				String value = request.getParameter(name);
				friend_id_list.add(value);
			}
		}
		
		// 무조건 plans, members_plans 입력
		PlanService ps = new PlanService();
		ps.insertPlan(plan_id, plan_name, host_id, numbers);
		
		// 날짜 선택 안했으면 (장소만 선택)
		if(host_date.equals("")) {
			// members_plans에 lat, lon 입력
			System.out.println("host_date: " + host_date);
		} 
		
		// 장소 선택 안했으면 (날짜만 선택)
		if(host_place.equals("")) {
			// date_options에 plan_id, host_date 입력
		}
		
		else {
			System.out.println("host_date 없음");
		}
		if(!host_place.equals("")) {
			System.out.println("host_place: " + host_place);			
		} else {
			System.out.println("host_place 없음");
		}
		System.out.println("host_id: " + host_id);
		System.out.println("plan_name: " + plan_name);
		System.out.println("membercount: " + numbers);
		
		for(String f:friend_id_list) {
			System.out.println("friends: " + f);
		}
		// host_id, plan_name, membercount --> plans
		// host_date --> date_options
		// host_id, friends --> members_plans
		
		// members_plans에 insert하려면  plan_id가 필요.
		// plan_id를 어떻게 가져오지..? 
		// 프로시저 써야하나
		/*
		
		System.out.println("host_date: " + host_date);
		System.out.println("host_place: " + host_place);
		*/
		
		response.sendRedirect("PlanSelectServlet");
	}

}
