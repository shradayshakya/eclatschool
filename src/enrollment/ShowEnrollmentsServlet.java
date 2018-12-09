/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Enrollment;
import data.EnrollmentDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.UrlHandling;
import tools.UrlHandling;

/**
 *
 * @author shinigami
 */
public class ShowEnrollmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String url ="/adminpanel/showEnrollments.jsp";
        Enrollment enrollments[] = EnrollmentDB.getEnrollments();
        request.setAttribute("enrollments", enrollments);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
