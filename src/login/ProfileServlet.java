package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		req.getRequestDispatcher("profile.html").include(req, resp);

		HttpSession session = req.getSession(false);
		if (session != null)
		{
			String name = (String) session.getAttribute("name");
			out.print("Hello " + name + ", you are logged in");
		} else
		{
			out.print("You have to login first");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		out.close();
	}

}
