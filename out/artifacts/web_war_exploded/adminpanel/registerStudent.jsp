<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@include file="layout/header.jsp" %>
<%@include file="layout/navbar.jsp" %>
        
     <div class="card mt-4 mx-auto w-75 p-2 shadow-lg ">
                <h5 class="card-header bg-dark text-white text-center">Register Student</h5>
        <form action = "<%=UrlHandling.getDomain()%>/adminpanel/registerstudent" method = "post">
            <div class ="row">
                <div class="form-group col-md-12">
                <label for="name">Name</label>
                <input type="text" class="form-control"  name ="name" placeholder="Enter student name" required="required">
                </div>
            </div>
            
            <div class = 'row'>
                <div class="form-group col-md-6">
                <label for="rollNumber">Roll number</label>
                <input type="text" class="form-control"  name = 'rollNumber' placeholder="Enter roll number" required="required">
                </div>
                
                <div class="form-group col-md-6">
                <label for="address">Address</label>
                <input type="text" class="form-control" name ='address'  placeholder="Enter address" required="required">
                </div>
             </div>
            
             <div class="row">
            <div class="form-group col-md-12">
                <label for="contactNumber">Contact Number</label>
                <input type="text" class="form-control" name='contactNumber' placeholder="Enter contact number" required="required">
            </div>
             </div>
            <div class="row">
            <div class="form-group col-md-12">
                <label for="dob">Date of birth</label>
                <input type="date" class="form-control" name='dob' placeholder="Enter data of birth" required="required">
                </div>
             </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name='email' placeholder="Enter email" required="required">
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name='password' placeholder="Enter password" required="required">
                </div>
            </div>
        
            <div class ="d-flex justify-content-center ">
            <button type="submit" class="btn btn-dark shadow-lg ">Register</button> &nbsp;
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/showstudents" class="btn btn-dark shadow-lg ">Cancel</a>
            </div>
         </form>
        </div>
<%@include file="layout/footer.jsp" %>