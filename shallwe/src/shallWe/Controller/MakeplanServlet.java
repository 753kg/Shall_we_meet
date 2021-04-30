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

import shallWe.Service.MemberPlanService;
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
		   
		String host_place = request.getParameter("host_place");

		String host_lat = request.getParameter("host_lat");
		String host_lon = request.getParameter("host_lon");
		System.out.println(System.currentTimeMillis());

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
		
		//1.plans insert
		PlanService ps = new PlanService();
		ps.insertPlan(plan_id, plan_name, host_id, numbers);
		MemberPlanService mps = new MemberPlanService();
		//2.장소만 선택하는 경우 
		//-host : members_plans(member_id,plan_id,lat,lon
		//-친구들 : members_plans(member_id,plan_id)-->위치는 finddepartureServlet
		for(String friend_id : friend_id_list) {
			mps.insertMemberPlan(plan_id, friend_id, 0.0, 0.0);
		}
		
		
	
		
		
		response.sendRedirect("PlanSelectServlet");
	}

}
