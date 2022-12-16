package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request: 클라이언트가 요청한(보낸) 내용들이 담겨있다.
		int n1 = Integer.parseInt(request.getParameter("n1")); //int형으로 변경
		int n2 = Integer.parseInt(request.getParameter("n2")); //int형으로 변경
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		String op = request.getParameter("op"); // 연산자
		System.out.println("op: " + op);
		
		long result = 0; // 연산의 결과를 담을 변수
		
		switch(op) {
		case "+": result = n1 + n2; break;
		case "-": result = n1 - n2; break;
		case "*": result = n1 * n2; break;
		case "/": result = n1 / n2; break;
		}
		
		request.setAttribute("result", result);
		getServletContext().getRequestDispatcher("/ch08/calcResult.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
