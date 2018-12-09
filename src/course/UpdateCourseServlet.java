/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import business.Course;
import data.CourseDB;
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
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String name = request.getParameter("name");
        Course course = CourseDB.getCourse(name);
        request.setAttribute("course", course);
        
        getServletContext()
                .getRequestDispatcher("/adminpanel/updateCourse.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        String identifier = request.getParameter("identifier");
         CourseDB.updateCourse(identifier, name, amount, discount);
     
         response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showcourses");
        
    }
}
