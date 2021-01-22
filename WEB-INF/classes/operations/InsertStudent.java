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
import validation.NameValidation;

@WebServlet(name = "insert", urlPatterns = { "/insert" })
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertStudent() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Student s = new Student();
		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setCourse(request.getParameter("course"));
		PrintWriter out = response.getWriter();
		
		NameValidation nm = new NameValidation();
		boolean validate = nm.validate(s.getName());
		
		if(validate) {
				StudentDAO studentDAO = new StudentDAOimplement();
				boolean res = studentDAO.insert(s);
				if(res) {
					System.out.println("Inserted Successfully!");
					RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
					rd.include(request, response);
					out.print("<h2 style=\"text-align:center;color: #00805e;padding:10px;font-family: \"Times New Roman\", Times, serif;\">Details Saved!</h2>");
				}else {
					System.out.println("Insertion Failure!");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
					out.print("<h2 style=\"text-align:center;color: #ff4d4d;padding:10px;font-family:\"Times New Roman\", Times, serif;\">Failed To Save.Try Again!</h2>");
				}
		}else {
				System.out.println("Insertion Failure!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				out.print("<h2 style=\"text-align:center;color: #ff4d4d;padding:10px;font-family:\"Times New Roman\", Times, serif;\">Use Only Characters!</h2>");
		}
	}

}
