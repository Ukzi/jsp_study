package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   ProductService service;

   
   @Override
   public void init(ServletConfig config) throws ServletException {
      super.init(config);
      //서블릿이 초기화 될 때 ProductService 객체를 생성 
      service = new ProductService();
   }
   
   

   //클라이언트에서 request가 오면 service가 실행된다. 
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action"); // action 파라미터의 값을 얻어온다. 
      String view = "";
      
      if (action == null) {
         getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
      } else {
         switch(action) {
         case "list": view = list(request, response); break;
         case "info": view = info(request, response); break;
         }
         
         getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
      }
   }


   private String info(HttpServletRequest request, HttpServletResponse response) {
      // 한 가지 상품만 가져온다. 
      Product p = service.find(request.getParameter("id"));
      request.setAttribute("p", p);
      return "productInfo.jsp";
   }



   private String list(HttpServletRequest request, HttpServletResponse response) {
      // 모든 상품을 가져온다.
      List<Product>plist = service.findAll();
      request.setAttribute("products", plist);
      return "productList.jsp";
   }
}