/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Student;
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
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roll = request.getParameter("roll");
        Student student = StudentDB.getStudent(roll);
        request.setAttribute("student", student);
        
        getServletContext()
                .getRequestDispatcher(UrlHandling.getDomain()+"/adminpanel/updateStudent.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roll = request.getParameter("roll");
        String rollNumber = request.getParameter("rollNumber");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String contactNumber = request.getParameter("contactNumber");
         StudentDB.updateStudent(roll, rollNumber, name, address, dob, contactNumber);
     
        response.sendRedirect("/adminpanel/showstudents");
    }

}
