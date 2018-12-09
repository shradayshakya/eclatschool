/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import business.Student;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Student;
import data.StudentDB;
import tools.UrlHandling;

/**
 *
 * @author shinigami
 */
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String roll = request.getParameter("roll");
        StudentDB.deleteStudent(roll);
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showstudents");
       
    }


}
