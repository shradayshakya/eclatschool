package enrollment;

import business.Course;
import business.Student;
import business.Enrollment;
import data.CourseDB;
import data.EnrollmentDB;
import data.StudentDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.UrlHandling;

/**
 *
 * @author shinigami
 */
public class RegisterEnrollmentServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student students[] = StudentDB.getStudents();
        request.setAttribute("students", students);
        
        Course courses[] = CourseDB.getCourses();
        request.setAttribute("courses", courses);
       getServletContext().getRequestDispatcher("/adminpanel/registerEnrollment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentRollNumber = request.getParameter("student");
        String courseName = request.getParameter("course");
        int paid = Integer.parseInt(request.getParameter("paid")) ;
        Course course = CourseDB.getCourse(courseName);
        int amount = course.getAmount();
        int discount = course.getDiscount();
        int due = amount -discount - paid;
        Enrollment enroll = new Enrollment(studentRollNumber,courseName,paid,due);
        EnrollmentDB.insert(enroll);
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showenrollments");
    }
}
