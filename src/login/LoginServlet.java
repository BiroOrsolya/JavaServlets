package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 3758323642802126996L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);

		String name = req.getParameter("name");
		String password = req.getParameter("password");

		if (password.equals("pony123") && name.equals("pony"))
		{
			out.print("Welcome " + name);
			HttpSession session = req.getSession();
			session.setAttribute("name", name);

		} else
			out.println("Bad username or password ! Permission denied");
		req.getRequestDispatcher("login.html");
		out.close();

	}

}
