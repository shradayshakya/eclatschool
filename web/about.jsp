<%@page import ="tools.*"%>
<%@include file="layout/header.jsp"%>
<link href='<%=UrlHandling.getDomain()%>/styles/heroimage.css' rel='stylesheet'>
<style>
    .hero-image {
        background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("<%=UrlHandling.getDomain()%>/img/car1.jpg");
        height: 89.2%;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        position: relative;
    }
</style>
<%@include file="layout/navbar.jsp"%>


<div class="hero-image">
<div class="hero-text">
    <h1 style="font-size: 45px">About us</h1>

    <p>Don&#39;t stress. Do your best. Forget the rest.</p>

</div>



<%@include file="layout/footer.jsp"%>
<script>
    $("#aboutnav").addClass("active");
    $("footer").addClass("fixed-bottom").addClass("text-light");
</script>
<%@include file="layout/scripts.jsp"%>

