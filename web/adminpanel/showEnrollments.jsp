<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="business.Enrollment"%>

<%@include file="layout/header.jsp" %>
        <link rel="stylesheet" href="<%=UrlHandling.getDomain()%>/styles/button.css">
<%@include file="layout/navbar.jsp" %>
        
        <div class="card mt-2 mx-auto p-2 shadow-lg">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Student Roll Number</th>
                    <th scope="col">Course Name</th>
                    <th scope="col">Paid Amount</th>
                    <th scope="col">Due Amount</th>
                    <th scope="col">Update/Delete</th>
                </tr>
            </thead>
            <tbody>
                <% Enrollment enrollments[] = (Enrollment[])request.getAttribute("enrollments");%>
                
                <% for(Enrollment enrollment: enrollments){ %>
                <tr>
                    <td> <%=enrollment.getStudentRollNumber()%> </td>
                    <td> <%=enrollment.getCourseName()%> </td>
                    <td> <%=enrollment.getPaidAmount()%> </td>
                    <td> <%=enrollment.getDueAmount()%> </td>
                    
                    <td>
                        &nbsp;&nbsp;&nbsp;<a href = "<%=UrlHandling.getDomain()%>/adminpanel/updateenrollment?student=<%= enrollment.getStudentRollNumber() %>&course=<%= enrollment.getCourseName()%>"><i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href = "<%=UrlHandling.getDomain()%>/adminpanel/deleteenrollment?student=<%= enrollment.getStudentRollNumber() %>&course=<%= enrollment.getCourseName()%>"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
                 <%}%>
            </tbody>
        </table>
    </div>
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/registerenrollment" class="d-flex justify-content-center mt-3" style="text-decoration: none;"><button class="shadow-lg btn"><i class="fa fa-plus-square"></i> Register</button></a>
 <script>
                $("#navEnrollments").addClass("active");
</script>
            <%@include file="layout/footer.jsp" %>