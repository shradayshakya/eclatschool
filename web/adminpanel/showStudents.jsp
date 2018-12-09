<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="business.Student"%>

<%@include file="layout/header.jsp" %>
        <link rel="stylesheet" href="<%=UrlHandling.getDomain()%>/styles/button.css">
<%@include file="layout/navbar.jsp" %>

<div class="card mt-2 mx-auto p-2 shadow-lg">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Roll number</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Contact number</th>
                    <th scope="col">Date of birth</th>
                    <th scope="col">Update/Delete</th>
                </tr>
            </thead>
            <tbody>
                <% Student students[] = (Student[])request.getAttribute("students");%>
                
                <% for(Student student: students){ %>
                <tr>
                    <th scope="row"> <%= student.getRollNumber() %></th>
                    <td> <%=student.getName() %> </td>
                    <td> <%=student.getAddress() %> </td>
                    <td> <%=student.getContactNumber() %> </td>
                    <td> <%=student.getDob() %> </td>
                    
                    <td>
                        &nbsp;&nbsp;&nbsp;<a href = "<%=UrlHandling.getDomain()%>/adminpanel/updatestudent?roll=<%= student.getRollNumber() %>"><i class="fa fa-edit"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href = "<%=UrlHandling.getDomain()%>/adminpanel/deletestudent?roll=<%= student.getRollNumber() %>"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
                 <%}%>
            </tbody>
        </table>
    </div>
</div>
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/registerstudent" class="d-flex justify-content-center mt-3" style="text-decoration: none;"><button class="shadow-lg btn"><i class="fa fa-plus-square"></i> Register</button></a>

            <script>
                $("#navStudents").addClass("active");
                </script>
            
            <%@include file="layout/footer.jsp" %>

