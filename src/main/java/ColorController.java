import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutev.personelozluk.entity.Il;
import com.tutev.personelozluk.service.IlServis;

public class ColorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IlServis ilServis = new IlServis();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Il> list = ilServis.getAll();

		String color = request.getParameter("color");

		PrintWriter out = response.getWriter();

		out.println("<html> \n" + "<body> \n" + "<font size=\"12px\" color=\""
				+ color + "\">" + "Merhaba " + "</font> \n" + "</body> \n"
				+ "</html>");

		
		  for (Il il : list) { 
			  out.println(il.getTanim()); 
			  }
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
