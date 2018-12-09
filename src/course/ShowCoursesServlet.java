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
public class ShowCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String url = "/adminpanel/showCourses.jsp";
        Course courses[] = CourseDB.getCourses();
        request.setAttribute("courses", courses);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
