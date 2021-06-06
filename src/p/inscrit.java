package p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inscrit
 */
@WebServlet("/inscrit")
public class inscrit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscrit() {
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
		PrintWriter out = response.getWriter();
	
		client c =new client();
		c.setNom(request.getParameter("nom"));
		c.setPrenom(request.getParameter("prenom"));
		c.setAdr(request.getParameter("adr"));
		c.setMail(request.getParameter("mail"));
		c.setMdp(request.getParameter("mdp"));
		c.setDn(request.getParameter("dn"));
		code_inscrit a= new code_inscrit();
		if(a.verif(c))
		{out.println("adresse email deja existe");
		}
		else
		{
		int t=a.ajout(c);
		if(t==1)
		{response.sendRedirect("connexion.jsp");}
		else
		{
			out.println("erreur");}}
	}

}
