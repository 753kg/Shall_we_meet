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

@WebServlet("/masterSelectDate")
public class MasterSelectDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterSelectDateServlet() {
    	super();
    }
    //방장이 선택한 여러 날짜들을 DB로 넘기는 곳
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	String hostdates = request.getParameter("dates");
    	System.out.println(hostdates);
    	DateSelect service = new DateSelect();

    	request.setAttribute("hlist", service.convertArrayInsertMaDate("1", hostdates));
    	
    	RequestDispatcher rd = request.getRequestDispatcher("date/successPage.jsp");
    	rd.forward(request, response);
    
    	}
    }
