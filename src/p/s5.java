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
 * Servlet implementation class s5
 */
@WebServlet("/s5")
public class s5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/cnv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession ssesion=request.getSession();
		String e= (String)ssesion.getAttribute("em");
		compt c=new compt();
	c.setIc(request.getParameter("ic"));
c.setNbe(Integer.parseInt(request.getParameter("ne")));
	c.setCd(request.getParameter("cd"));
	c.setNc(request.getParameter("nc"));
	c.setF(request.getParameter("f"));
	c.setDb(request.getParameter("db"));
	c.setDf(request.getParameter("df"));
	c.setCat(request.getParameter("cat"));
	c.setCon(request.getParameter("con"));
	c.setGen(request.getParameter("gen"));
	c.setCu(e);
	code_compt a= new code_compt();
	if(a.verif(e, request.getParameter("ic")))
	{
	out.println("id deja existe");}
	else
	{
		int t=a.ajout(c);
		if(t==1)
		{response.sendRedirect("s4");}
		else
		{out.println("erreur");}}
		
	}
	
}
