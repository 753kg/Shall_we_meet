<<<<<<< HEAD
package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.MemberPlanService;

/**
 * Servlet implementation class FindDeparture
 */
@WebServlet("/makeplan/FindDeparture")
public class FindDepartureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDepartureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher rd = request.getRequestDispatcher("SelectLocationByMember.jsp");
		request.setAttribute("plan_id", request.getParameter("plan_id"));
		rd.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberPlanService mps = new MemberPlanService();
		
		mps.updateMemberLocation(request.getParameter("member_id"), request.getParameter("plan_id"), 
						request.getParameter("member_lat"), request.getParameter("member_lon"));
		
		 
		System.out.println(request.getParameter("member_lat"));
		System.out.println(request.getParameter("member_lon"));
		System.out.println(request.getParameter("member_id"));
		System.out.println(request.getParameter("plan_id"));
		
		
		
		

		//mps.insertMember(member_id,plan_id,locationList[0],locationList[1]);
		

	}

}
=======
package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.MemberPlanService;

/**
 * Servlet implementation class FindDeparture
 */
@WebServlet("/makeplan/FindDeparture")
public class FindDepartureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDepartureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher rd = request.getRequestDispatcher("SelectLocationByMember.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * MemberPlanService mps = new MemberPlanService(); double[]
		 * locationList=mps.convertToDouble(request.getParameter("location"));
		 */
		System.out.println(request.getParameter("member_lat"));

		//mps.insertMember(member_id,plan_id,locationList[0],locationList[1]);
		

	}

}
>>>>>>> refs/heads/Youyeon
