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
 * Servlet implementation class ajout_match
 */
@WebServlet("/ajout_match")
public class ajout_match extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajout_match() {
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
		if(request.getParameter("eq1").equals(request.getParameter("eq2")))
		{out.println("faux meme equipe");}
		else
		{
		match ma= new match();
	    ma.setIdm(request.getParameter("idm"));
		ma.setJtm(request.getParameter("jtm"));
		ma.setEq1(request.getParameter("eq1"));
		ma.setEq2(request.getParameter("eq2"));
		ma.setTm(request.getParameter("tm"));
		ma.setDm(request.getParameter("dm"));
		ma.setArm(request.getParameter("arm"));
		ma.setId_c(ic);
		ma.setUtili(e);
		code_match cm=new code_match();
		int t=cm.ajout(ma);
		if(t==1)
		{response.sendRedirect("s6");}
		else
		{out.println("erreur");}
		
	}
	}
}
