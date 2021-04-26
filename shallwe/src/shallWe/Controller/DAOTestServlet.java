package shallWe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.DAO.ActivityDAO;
import shallWe.DAO.MemberDAO;
import shallWe.DAO.PlanDAO;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.MemberVO;
import shallWe.VO.PlanVO;
import shallWe.VO.RestaurantVO;

/**
 * Servlet implementation class DAOTestServlet
 */
@WebServlet("/DAOTestServlet")
public class DAOTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAOTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mdao = new MemberDAO();
		String memberid = "mem1";
		String memberpw = "1234";
		MemberVO m = mdao.loginChk(memberid, memberpw);
		System.out.println(m);
		
		ActivityDAO adao = new ActivityDAO();
		String locname = "홍대";
		List<ActivityVO> alist = new ArrayList<ActivityVO>();
		alist = adao.selectActivityByLocationName(locname);
		System.out.println(alist);
		
		List<RestaurantVO> rlist = new ArrayList<>();
		rlist = adao.selectRestaurantByLocationName(locname);
		System.out.println(rlist);
		
		List<CafeVO> clist = new ArrayList<>();
		clist = adao.selectCafeByLocationName(locname);
		System.out.println(clist);
		
		PlanDAO pdao = new PlanDAO();
		List<PlanVO> plist = pdao.selectPlanByMemberId("mem1");
		System.out.println(plist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
