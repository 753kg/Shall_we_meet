package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.HotplaceService;
import shallWe.Service.MemberPlanService;
import shallWe.VO.HotplaceVO;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/makeplan/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plan_id = request.getParameter("plan_id");
		MemberPlanService mps = new MemberPlanService();
		HotplaceService hps= new HotplaceService();
		String[] hotplace3 = mps.informMiddlePlace(plan_id);
		List<HotplaceVO> hotlist = new ArrayList<>();
		for(String hotplace:hotplace3) {
			HotplaceVO hotplaceVO = hps.selectHotplaceLocationByName(hotplace);
			hotlist.add(hotplaceVO);
		}
		
		request.setAttribute("hotplaceList", hotlist);
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
