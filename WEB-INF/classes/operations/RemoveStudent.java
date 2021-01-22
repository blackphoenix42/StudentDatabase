package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentProfile.StudentDAOimplement;

@WebServlet(name = "remove", urlPatterns = { "/remove" })
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveStudent() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		boolean res = new StudentDAOimplement().remove(id);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.include(request, response);
		if(res) {
			out.print("<h2 style=\"text-align:center;color: #ff4d4d;padding:10px;font-family: \"Times New Roman\", Times, serif;\">Removed Student Details!</h2>");
		}else{
			out.print("<h2 style=\"text-align:center;color: #ff4d4d;padding:10px;\">Failed To Remove.Try Again!</h2>");
		}
		
	}

}
