/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Enrollment;
import data.EnrollmentDB;
import tools.UrlHandling;

/**
 *
 * @author shinigami
 */
public class DeleteEnrollmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String student = request.getParameter("student");
                String course = request.getParameter("course");
                EnrollmentDB.deleteEnrollment(student, course);
                response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showenrollments");
    }


}
