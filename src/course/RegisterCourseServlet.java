/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Course;
import data.CourseDB;
import tools.UrlHandling;

/**
 *
 * @author shinigami
 */
public class RegisterCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        
        Course course = new Course(name,amount,discount);
        
        CourseDB.insert(course);
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showcourses");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         getServletContext().getRequestDispatcher("/adminpanel/registerCourse.jsp").forward(request, response);
    }
    
}
