<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp" %>
<%@include file="layout/navbar.jsp" %>        
     <div class="card mt-4 mx-auto w-75 p-2 shadow-lg ">
                <h5 class="card-header bg-dark text-white text-center">Update Course Information</h5>
        <form action = "<%=UrlHandling.getDomain()%>/adminpanel/updatecourse" method = "post">
            <input type ="hidden" name ="identifier" value="${course.name}" >
            <div class ="row">
                <div class="form-group col-md-12">
                <label for="name">Name</label>
                <input type="text" class="form-control"  name ="name" placeholder="Enter course name" required="required" value = "${course.name}">
                </div>
            </div>
            
            <div class = 'row'>
                <div class="form-group col-md-6">
                <label for="amount">Amount</label>
                <input type="text" class="form-control"  name = 'amount' placeholder="Enter payement amount" required="required"  value = "${course.amount}">
                </div>
                
                <div class="form-group col-md-6">
                <label for="discount">Discount</label>
                <input type="text" class="form-control" name ='discount'  placeholder="Enter discount" required="required" value = "${course.discount}">
                </div>
             </div>
                
            <div class ="d-flex justify-content-center ">
            <button type="submit" class="btn btn-dark shadow-lg ">Update</button> &nbsp;
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/showcourses" class="btn btn-dark shadow-lg ">Cancel</a>
            </div>
         </form>
        </div>
<%@include file="layout/footer.jsp" %>
