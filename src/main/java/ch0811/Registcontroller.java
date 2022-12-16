package ch0811;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Registcontroller
 */
@WebServlet("/rcontrol")
public class Registcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RegistService service;
    
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//서블릿이 초기화 될 때 RegistService 객체를 생성
		service = new RegistService();
	}

    
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //         ^--- 매개변수 이름이 request가 아니라 req
		String view = "";
	
		if (action == null) {
	         getServletContext().getRequestDispatcher("/rcontrol?action=list").forward(request, response);
	      } else {
	         switch(action) {
	         case "list": view = list(request, response); break;
	         case "info": view = info(request, response); break;
	         }
	         
	         getServletContext().getRequestDispatcher("/ch0811/" + view).forward(request, response);
	      }
	
		
		
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist r = service.find(request.getParameter("id"));
		request.setAttribute("r", r);
		return "registInfo.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		// 모든 상품을 가져온다.
		List<Regist>rlist = service.findAll();
		request.setAttribute("regists", rlist);
		return "registList.jsp";
	}
	

}
