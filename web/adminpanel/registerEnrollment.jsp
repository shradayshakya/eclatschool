<%@page import="tools.*"%>
<%@page import="javax.servlet.http.Cookie"%>
<%
    if(CookieHandling.adminCookieExists(request.getCookies()) == false){
        response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="business.Course"%>
<%@ page import="business.Student"%>
<%@include file="layout/header.jsp" %>
<%@include file="layout/navbar.jsp" %>        

     <div class="card mt-4 mx-auto w-75 p-2 shadow-lg ">
                <h5 class="card-header bg-dark text-white text-center">Register Enrollment</h5>
        <form action = "<%=UrlHandling.getDomain()%>/adminpanel/registerenrollment" method = "post">
            <div class ="row">
                <div class="form-group col-md-12">
                <label>Student roll number</label>
                <select class="form-control"  name ="student" required="required">
                    <option disabled selected>Enter student's roll number</option>
                        <% Student students[] = (Student[])request.getAttribute("students");%>
                
                <% for(Student student: students){ %>
                    <option name = "<%=student.getRollNumber() %>"> <%=student.getRollNumber() %> </option>
                 <%}%>
                </select>
                </div>
            </div>
            
            <div class ="row">
                <div class="form-group col-md-12">
                <label for="course">Course</label>
                <select class="form-control"  name ="course" required="required" id ="course">
                    <option disabled selected>Enter course</option>
                        <% Course courses[] = (Course[])request.getAttribute("courses");%>
                
                <% for(Course course: courses){ %>
                    <option name = "<%=course.getName() %>"> <%=course.getName() %> </option>
                 <%}%>
                </select>
                </div>
            </div>
            
            <div class = 'row'>
                <div class="form-group col-md-12">
                <label for="paid">Paid Amount</label>
                <input type="number" class="form-control"  id = "paid" name = 'paid' placeholder="Enter paid amount" required="required">
                </div>
            </div>
        
            <div class ="d-flex justify-content-center ">
            <button type="submit" class="btn btn-dark shadow-lg ">Enroll</button> &nbsp;
            <a href="<%=UrlHandling.getDomain()%>/adminpanel/showenrollments" class="btn btn-dark shadow-lg ">Cancel</a>
            </div>
         </form>
        </div>
                 
<script>
    var courses = {
        <% for(Course course: courses){ %>
                    "<%=course.getName() %>":<%=course.getAmount()-course.getDiscount()%>,
                 <%}%>
    };
    $("#course").change(function(){
        $("#paid").val(courses[$("#course").val()]);
        var courseName = courses.indexOf(courses[$("#course").val()]);
        });


</script>

<%@include file="layout/footer.jsp" %>
