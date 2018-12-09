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
import data.UserDB;
import business.User;
import tools.UrlHandling;


/**
 *
 * @author shinigami
 */
public class RegisterStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String rollNumber = request.getParameter("rollNumber");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String contactNumber = request.getParameter("contactNumber");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Student student = new Student(rollNumber,name,address,dob,contactNumber);
        User user = new User(rollNumber,password,email);

        StudentDB.insert(student);
        UserDB.insert(user);
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showstudents");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         getServletContext().getRequestDispatcher("/adminpanel/registerStudent.jsp").forward(request, response);
    }
}