package user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import business.Student;
import data.StudentDB;
import data.UserDB;
import tools.*;

public class UserProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = CookieHandling.getUserEmail(request.getCookies());
        String rollNumber = UserDB.getRollNumber(email);
        Student student = StudentDB.getStudent(rollNumber);
        request.setAttribute("student",student);
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request,response);
    }
}
