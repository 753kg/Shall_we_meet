package shallWe.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.RequiresStatement;

import shallWe.DAO.DateDAO;
import shallWe.Service.DateSelect;
import shallWe.Util.ConvertUtil;
import shallWe.VO.DateOptionVO;

@WebServlet("/date/masterSelectDate")
public class MasterSelectDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterSelectDateServlet() {
    	super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	String hostdates = request.getParameter("dates");
    	System.out.println(hostdates);
    	DateSelect service = new DateSelect();

    	// 호스트데이트 갯수만큼 date_options에 insert된다.
    	request.setAttribute("hlist", service.convertArrayInsert(1, hostdates));
    	
    	RequestDispatcher rd = request.getRequestDispatcher("successPage.jsp");
    	rd.forward(request, response);
    
    	}
    }

//	String obj = request.getParameter("plan_id");
//	if(obj == null) throw new ServletException("약속이 없습니다.");
	
//	int planid = Integer.parseInt(obj);
//	DateSelect service = new DateSelect();
//	request.setAttribute("plan_id", service.selectMemIdplanId(planid));
	
//	RequestDispatcher rd = request.getRequestDispatcher("masterSelectDate.jsp");
//	rd.forward(request, response);

