<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>

<%@include file="layout/header.jsp" %>
  <link href='<%=UrlHandling.getDomain()%>/styles/heroimage.css' rel='stylesheet'>
<%@include file="layout/navbar.jsp" %>

<div class="hero-image">
  <div class="hero-text">
    <h1 style="font-size: 45px">Admin Panel</h1>

    <a class = "link d-flex justify-content-center text-white"  href="<%=UrlHandling.getDomain()%>/adminpanel/registerstudent">
                 <i class="fa fa-admin"></i>
                &nbsp;REGISTER STUDENT
    </a>
    
             <a class = "link d-flex justify-content-center text-white" href="<%=UrlHandling.getDomain()%>/adminpanel/registercourse">
                 <i class="fa fa-book"></i> &nbsp;ADD NEW COURSE
            </a>
    
               <a class = "link d-flex justify-content-center text-white" href="<%=UrlHandling.getDomain()%>/adminpanel/registerenrollment">
               <i class="fa fa-money"></i>
               &nbsp;ENROLL
            </a>  
    
  </div>
</div>
<%@include file="layout/footer.jsp" %>