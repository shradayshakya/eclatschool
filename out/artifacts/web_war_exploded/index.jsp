<%@page import ="tools.*"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/navbar.jsp"%>

<div class="hero-image">
    <div class="hero-text">
        <h1>Eclat School</h1>
        <p>Don&#39;t stress. Do your best. Forget the rest.
        </p>
    </div>
</div>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <div class = "row">
            <div class="col-md-4 border-light shadow-lg">
                <img src="<%=UrlHandling.getDomain()%>/img/Iruka.png" style="width:100%; height:90%">
            </div>
            <div class="col-md-8">
                <h3>The principal speaks..</h3>
                <p>
                    Education helps us to be healthy, save many lives, boosts economic growth, earn money, raise quality crop, promote peace in the society, eradicate poverty, remove gender discrimination and inequality, promote women and children rights, bring good governance, remove corruption, make aware about fundamental rights and so many. Good education does not mean to study hard and get good results however it is to conquer new things for the betterment of whole mankind.
                </p>
                <p>
                    Education is not about to gain only knowledge, however it means, learning the ways to be happy, learning the way to keep others happy, learning the way to live in society, learning the way to tackle challenges, learning the way to help others, learning the way to care older, and learning the way how to behave others. My dear friends, education is like a healthy food which nourishes us both internally and externally. It makes us strong internally and gives lots of confidence by making our personality and giving us knowledge. Good education is only way to remove bad habits, poverty, inequality, gender discrimination and so many social issues.
                </p>
            </div>
        </div>
    </div>
</div>

<%@include file="layout/footer.jsp"%>

<script>
    $("#homenav").addClass("active");
</script>
<%@include file="layout/scripts.jsp"%>