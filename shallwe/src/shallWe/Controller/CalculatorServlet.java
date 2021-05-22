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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import shallWe.Service.HotplaceService;
import shallWe.Service.MemberPlanService;
import shallWe.VO.HotplaceVO;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/makeplan/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션으로 멤버 아이디를 받아옴
		HttpSession session = request.getSession();
		String memberid = (String) session.getAttribute("memberid");
		//서비스 선언
		MemberPlanService mps = new MemberPlanService();
		HotplaceService hps= new HotplaceService();
		//get방식으로 plan_id를 받아옴
		String plan_id = request.getParameter("plan_id");
		
		request.setAttribute("plan_id", plan_id);
		//핫플레이스 이름 세가지 받아옴
		String[] hotplace3 = mps.informMiddlePlace(plan_id);
		
		//핫플레이스 이름을 통해 hotlist를 생성
		List<HotplaceVO> hotlist = new ArrayList<>();
		for(String hotplace:hotplace3) {
			HotplaceVO hotplaceVO = hps.selectHotplaceLocationByName(hotplace);
			hotlist.add(hotplaceVO);
		}
		
		//회원과 핫플레이스 간에 거리를 계산
		String[] distances = mps.calculateMemberDistance(mps.selectMemberLocation(plan_id, memberid),hotlist);
		
		request.setAttribute("hotplaceList", hotlist);
		request.setAttribute("distances", distances);
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
