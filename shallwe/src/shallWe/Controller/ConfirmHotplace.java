package shallWe.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shallWe.Service.PlanService;

/**
 * Servlet implementation class ConfirmHotplace
 */
@WebServlet("/makeplan/confirmHotplace")
public class ConfirmHotplace extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String plan_id = request.getParameter("plan_id");
      String hotplace_name = request.getParameter("hotplace_name");
      PlanService service = new PlanService();
      service.updateHotplace(plan_id, hotplace_name);
      RequestDispatcher rd = request.getRequestDispatcher("calculator");
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