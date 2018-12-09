<%@page import ="tools.*"%>
<%
    if(!CookieHandling.userCookieExists(request.getCookies())){
        response.sendRedirect(UrlHandling.getDomain()+"/home");
    }
%>
<%@page import="business.Student"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/navbar.jsp"%>

<% Student student = (Student) request.getAttribute("student"); %>
<div class="container">
<div class="panel panel-default" >
    <div class = "panel-body">
        <div class = "d-flex justify-content-center mt-3">
            <img src = "<%=UrlHandling.getDomain()%>/img/default.jpg" width = '200px' height= '200px'>
        </div>
    </div>

    <div class = "panel-body">
        <hr>
        <div class = "d-flex justify-content-center  mt-3">
            <strong>Name:</strong>
        </div>
        <div class = "d-flex justify-content-center">
           <%=student.getName()%>
        </div>
    </div>

    <div class = "panel-body">
        <div class = "d-flex justify-content-center  mt-3">
            <strong>Roll number</strong>
        </div>
        <div class = "d-flex justify-content-center">
            <%=student.getRollNumber()%>
        </div>
    </div>


    <div class = "panel-body">
        <div class = "d-flex justify-content-center  mt-3">
            <strong>Address</strong>
        </div>
        <div class = "d-flex justify-content-center">
            <%=student.getAddress()%>
        </div>
    </div>

    <div class = "panel-body">
        <div class = "d-flex justify-content-center  mt-3">
            <strong>DOB:</strong>
        </div>
        <div class = "d-flex justify-content-center">
            <%=student.getDob()%>
        </div>
    </div>

    <div class = "panel-body">
        <div class = "d-flex justify-content-center  mt-3">
            <strong>Contact number:</strong>
        </div>
        <div class = "d-flex justify-content-center">
            <%=student.getContactNumber()%>
        </div>
    </div>
</div>
</div>




<%@include file="layout/footer.jsp"%>
<%@include file="layout/scripts.jsp"%>

