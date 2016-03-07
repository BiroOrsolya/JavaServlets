package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 3758323642802126996L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		req.getRequestDispatcher("index.html").include(req, resp);

		String name = req.getParameter("name");
		String password = req.getParameter("password");

		if (name.equals("pony") && password.equals("pony123"))
			out.println("Welcome " + name);
		else
			out.println("Bad username or password ! Permission denied");
		out.close();

		// System.out.println("pony");

		// super.doPost(req, resp);
	}

}
