package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentProfile.Student;
import studentProfile.StudentDAO;
import studentProfile.StudentDAOimplement;

@WebServlet(name = "update", urlPatterns = { "/update" })
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateStudent() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Student s = new Student();
		int oldId = Integer.parseInt(request.getParameter("oldId"));
//		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setId(oldId);
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setCourse(request.getParameter("course"));
		
		StudentDAO studentDAO = new StudentDAOimplement();
		boolean res = studentDAO.update(s,oldId);
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.include(request, response);
		if(res) {
			out.print("<h2 style=\"text-align:center;color: #00805e;padding:10px;font-family: \"Times New Roman\", Times, serif;\">Updated Details!</h2>");
		}else {
			out.print("<h2 style=\"text-align:center;color: #ff4d4d;padding:10px;font-family: \"Times New Roman\", Times, serif;\">Failed to update.Try Again!</h2>");
		}
		
	}

}
