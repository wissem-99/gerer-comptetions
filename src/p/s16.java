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
 * Servlet implementation class s16
 */
@WebServlet("/s16")
public class s16 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s16() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/").forward(request, response);

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
		ee.setId_c(ic);
		ee.setUtili(e);

		code_equipe ce= new code_equipe();
		int t=ce.sup(ee);
		if(t==1)
		{response.sendRedirect("s6");}
		else
		{out.println("echec");}

	}
	}


