/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import business.Student;
import data.StudentDB;
import tools.UrlHandling;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author shinigami
 */
public class ShowStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/adminpanel/showStudents.jsp";
        Student students[] = StudentDB.getStudents();
        request.setAttribute("students", students);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
