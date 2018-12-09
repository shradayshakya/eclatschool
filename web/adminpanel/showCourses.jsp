<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="business.Course"%>

<%@include file="layout/header.jsp" %>
        <link rel="stylesheet" href="<%=UrlHandling.getDomain()%>/styles/button.css">
<%@include file="layout/navbar.jsp" %>

        <div class="card mt-2 mx-auto p-2 shadow-lg">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Course name</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Discount</th>
                    <th scope ="col">Update/Delete</th>
                </tr>
            </thead>
            <tbody>
                <% Course courses[] = (Course[])request.getAttribute("courses");%>
                
                <% for(Course course: courses){ %>
                <tr>
                    <th> <%=course.getName() %> </th>
                    <td> <%=course.getAmount()%> </td>
                    <td> <%=course.getDiscount()%> </td>
                    <td>
                       &nbsp;&nbsp;&nbsp; <a href = "<%=UrlHandling.getDomain()%>/adminpanel/updatecourse?name=<%= course.getName() %>"><i class="fa fa-edit"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href = "<%=UrlHandling.getDomain()%>/adminpanel/deletecourse?name=<%= course.getName() %>"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
                 <%}%>
            </tbody>
        </table>
    </div>
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/registercourse" class="d-flex justify-content-center mt-3" style="text-decoration: none;"><button class="btn shadow-lg"><i class="fa fa-plus-square"></i> Register</button></a>

             <script>
                $("#navCourses").addClass("active");
                </script>
<%@include file="layout/footer.jsp" %>