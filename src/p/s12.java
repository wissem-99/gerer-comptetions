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
 * Servlet implementation class s12
 */
@WebServlet("/s12")
public class s12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ssesion=request.getSession();
		String e= (String)ssesion.getAttribute("em");
		code_compt c= new code_compt();
		request.setAttribute("compt",c.rec(e));
		this.getServletContext().getRequestDispatcher("/mc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession ssesion=request.getSession();
		String e= (String)ssesion.getAttribute("em");
		compt c=new compt();
		c.setCu(e);
	c.setIc(request.getParameter("ic"));
c.setNbe(Integer.parseInt(request.getParameter("ne")));
	c.setF(request.getParameter("f"));
	code_compt a= new code_compt();
	if(a.verif(e, request.getParameter("ic")))
	{
	int t=a.mod(c);
	if(t==1)
	{response.sendRedirect("s4");}
	else
	{out.println("faux");}
	}
	else
	{out.println("id nexiste pas");}
	}
}

