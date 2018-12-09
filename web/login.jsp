<%@page import ="tools.*"%>

<%
    if(CookieHandling.userCookieExists(request.getCookies())){
        response.sendRedirect(UrlHandling.getDomain()+"/home");
    }
%>


<%@include file="layout/header.jsp"%>
<%@include file="layout/navbar.jsp"%>

<div class="card mt-4 mx-auto w-25">
    <h5 class="card-header bg-dark text-white text-center">Log in</h5>
    <form class="card-body" action ="<%=UrlHandling.getDomain()%>/login" method="POST" id ="form">
        <div class="row">
            <div class="col mt-4">
                <label>Email</label>
                <input type="email" class="form-control" name = 'email' placeholder="Enter email" required>
            </div>
        </div>

        <div class="row">
            <div class="col mt-4">
                <label>Password</label>
                <input type="password" class="form-control" name='password' placeholder="Enter password" required>
            </div>
        </div>

        <div class="mt-4 d-flex justify-content-center">
            <button type="submit" class="btn btn-dark mt-2">Log in</button>
        </div>
    </form>
</div>

<%@include file="layout/footer.jsp"%>
<script>
    $("footer").addClass("fixed-bottom");
</script>
<%@include file="layout/scripts.jsp"%>