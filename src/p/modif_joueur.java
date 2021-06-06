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
 * Servlet implementation class modif_joueur
 */
@WebServlet("/modif_joueur")
public class modif_joueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modif_joueur() {
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
		
		
		joueur jo = new joueur();
		jo.setStj(request.getParameter("stj"));
		jo.setIdj(request.getParameter("idj"));
		jo.setId_c(ic);
		jo.setUtili(e);
	
		code_joueur cj= new code_joueur();
		int t=cj.modif(jo);
		if(t==1)
		{response.sendRedirect("s6");}
		else
		{out.println("erreur");}
		
	}

}
