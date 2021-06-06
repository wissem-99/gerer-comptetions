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
 * Servlet implementation class s8
 */
@WebServlet("/s8")
public class s8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion=request.getSession();
		String e= (String)ssesion.getAttribute("em");
		 pro p = new pro();
		request.setAttribute("client",p.rec(e));
		this.getServletContext().getRequestDispatcher("/profil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession ssesion=request.getSession();
		String e= (String)ssesion.getAttribute("em");
		 pro p = new pro();
		 client c=new client();
		 c.setNom(request.getParameter("nom"));
		 c.setPrenom(request.getParameter("prenom"));
		 c.setAdr(request.getParameter("adr"));
		 c.setMdp(request.getParameter("mdp"));
		 c.setDn(request.getParameter("dn"));
		 out.println("nom");
		if (p.update(c, e)==1)
		{response.sendRedirect("s8");}
		else
		{out.println("erreur");}
	}

}
