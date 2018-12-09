<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page import="business.Student"%>
<%@page import="business.Enrollment"%>
<%@page import="business.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp" %>
<%@include file="layout/navbar.jsp" %>

<% Enrollment enrollment = (Enrollment)request.getAttribute("enrollment");%>
     <div class="card mt-4 mx-auto w-75 p-2 shadow-lg ">
                <h5 class="card-header bg-dark text-white text-center">Update Payement Information</h5>
        <form action = "<%=UrlHandling.getDomain()%>/adminpanel/updateenrollment" method = "post">
            <input type ="hidden" name ="studentIdentifier" value="<%=enrollment.getStudentRollNumber()%>" >
            <input type ="hidden" name ="courseIdentifier" value="<%=enrollment.getCourseName()%>" >
            
            <div class ="row">
                <div class="form-group col-md-12">
                <label for="student">Student Roll number</label>
                <select class="form-control"  name ="student" required="required">
                    <option disabled selected>Enter student's roll number</option>
                        <% Student students[] = (Student[])request.getAttribute("students");%>
                        
                <% for(Student student: students){ %>
                <option name = "<%=student.getRollNumber()%>"<% if(student.getRollNumber().equals(enrollment.getStudentRollNumber())){ %> selected ="selected"<%}%>> 
                        <%=student.getRollNumber() %> 
                        </option>
                 <%}%>
                </select>
                </div>
            </div>
                
             <div class ="row">
                <div class="form-group col-md-12">
                <label for="course">Course Name</label>
                <select class="form-control"  name ="course" required="required">
                    <option disabled selected>Enter course</option>
                        <% Course courses[] = (Course[])request.getAttribute("courses");%>
                
                <% for(Course course: courses){ %>
                    <option name = "<%=course.getName() %>" <% if(course.getName().equals(enrollment.getCourseName())){ %> selected ="selected"<%}%> > <%=course.getName() %> </option>
                 <%}%>
                </select>
                </div>
            </div>
            
            <div class = 'row'>
                <div class="form-group col-md-6">
                <label for="due">Due Amount</label>
                <input type="text" class="form-control" name ='due'  value=${enrollment.dueAmount} disabled>
                </div>
                
                <div class="form-group col-md-6">
                <label for="payement">Payement</label>
                <input type="number" max="${enrollment.dueAmount}" class="form-control" name ='paidAmount'  placeholder="Enter payement">
                </div>
             </div>
                
            <div class ="d-flex justify-content-center ">
            <button type="submit" class="btn btn-dark shadow-lg ">Update</button> &nbsp;
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/showenrollments" class="btn btn-dark shadow-lg ">Cancel</a>
            </div>
         </form>
        </div>
<%@include file="layout/footer.jsp" %>
