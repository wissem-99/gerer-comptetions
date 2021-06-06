package p;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class s6
 */
@WebServlet("/s6")
public class s6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion=request.getSession();
	
		
		String ic= (String)ssesion.getAttribute("ic");
		String e= (String)ssesion.getAttribute("em");
		code_compt c= new code_compt();
		code_equipe eq= new code_equipe();
		code_joueur jo= new code_joueur();
		code_arbitre ar =new code_arbitre();
		code_match cm= new code_match();
		
		request.setAttribute("match_non_joues",cm.listematch_non_joues(ic, e));
		request.setAttribute("match",cm.recma(ic, e));
		request.setAttribute("match",cm.recma(ic, e));
		request.setAttribute("arbitre",ar.recar(ic, e));
		request.setAttribute("joueur",jo.recj(ic, e));
		request.setAttribute("equipe",eq.rec(ic,e));
		request.setAttribute("compt",c.recd(e,ic));
		this.getServletContext().getRequestDispatcher("/menu_admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion=request.getSession();
		String ic=request.getParameter("ic");
		ssesion.setAttribute("ic", ic);
		response.sendRedirect("s6");
	}

}
