package shallWe.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.DateSelect;
import shallWe.Util.ConvertUtil;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

@WebServlet("/memberSelectDate")
public class MemberDateSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDateSelectServlet() {
        super();
    }
    //멤버가 고른 날짜들을 DB에 넘긴다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
    	
    	String memberdates = request.getParameter("dates");
    	System.out.println(memberdates);
    	DateSelect service = new DateSelect();

    	try {
			request.setAttribute("mlist", service.updateMemberDates("1", "mem1", memberdates));
		
			RequestDispatcher rd = request.getRequestDispatcher("date/successPage.jsp");
	    	rd.forward(request, response);
	   
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    
    	}
	}
	
