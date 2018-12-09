/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import business.Course;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Enrollment;
import business.Student;
import data.CourseDB;
import data.EnrollmentDB;
import data.StudentDB;
import tools.UrlHandling;
/**
 *
 * @author shinigami
 */
public class UpdateEnrollmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Student students[] = StudentDB.getStudents();
        request.setAttribute("students", students);
        
        Course courses[] = CourseDB.getCourses();
        request.setAttribute("courses", courses);
        
        String student = request.getParameter("student");
        String course = request.getParameter("course");
        Enrollment enrollment = EnrollmentDB.getEnrollment(student, course);
        request.setAttribute("enrollment",enrollment);
        
         getServletContext()
                .getRequestDispatcher("/adminpanel/updateEnrollment.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentIdentifier = request.getParameter("studentIdentifier");
        String courseIdentifier = request.getParameter("courseIdentifier");
        String studentRollNumber = request.getParameter("student");
        String courseName = request.getParameter("course");
        
        String paid = request.getParameter("paidAmount");
        int amount;
        if(paid == ""){
            amount = 0;
        }else{
            amount = Integer.parseInt(paid);
        }
        Enrollment enrollment = EnrollmentDB.getEnrollment(studentIdentifier, courseIdentifier);
        Course course = CourseDB.getCourse(courseName);
        int paidAmount = amount + enrollment.getPaidAmount();
        int dueAmount = course.getAmount() - course.getDiscount()- paidAmount;
        
        EnrollmentDB.updateEnrollment(studentIdentifier, courseIdentifier, studentRollNumber, courseName, paidAmount, dueAmount);
        
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/showenrollments");
    }
}
