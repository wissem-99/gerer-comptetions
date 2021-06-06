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
 * Servlet implementation class ser_ajou_equipe
 */
@WebServlet("/ser_ajou_equipe")
public class ser_ajou_equipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser_ajou_equipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/menu_admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion=request.getSession();
		PrintWriter out = response.getWriter();
		
		String ic= (String)ssesion.getAttribute("ic");
		String e= (String)ssesion.getAttribute("em");
		equipe ee= new equipe();
		ee.setId_e(request.getParameter("id_e"));
		ee.setDf(request.getParameter("df"));
		ee.setNom_e(request.getParameter("nom_e"));
		ee.setNomp_e(request.getParameter("nomp_e"));
		ee.setNom_t(request.getParameter("nom_t"));
		ee.setId_c(ic);
		ee.setUtili(e);
		
		code_equipe ce= new code_equipe();
		int t=ce.ajout(ee);
		if(t==1)
		{out.println("ok");}
		else
		{out.println("echec");}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
