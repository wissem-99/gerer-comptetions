package p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ajout_arbitre
 */
@WebServlet("/ajout_arbitre")
public class ajout_arbitre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajout_arbitre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion=request.getSession();
		PrintWriter out = response.getWriter();
		String ic= (String)ssesion.getAttribute("ic");
		String e= (String)ssesion.getAttribute("em");
		arbitre ar= new arbitre();
		ar.setIdar(request.getParameter("idar"));
		ar.setNomar(request.getParameter("nomar"));
		ar.setPrenomar(request.getParameter("prenomar"));
		ar.setPaysar(request.getParameter("paysar"));
		ar.setDnar(request.getParameter("dnar"));
		ar.setId_c(ic);
		ar.setUtili(e);
		out.println(request.getParameter("dnar"));
		code_arbitre car= new code_arbitre();
		
		int t=car.ajout(ar);
		if(t==1)
		{response.sendRedirect("s6");}
		else
		{out.println("erreur");}
		
	}

}
