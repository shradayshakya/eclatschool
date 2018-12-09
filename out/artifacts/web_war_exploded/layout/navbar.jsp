        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <img class = "navbar-brand" src ="<%=UrlHandling.getDomain()%>/img/eclat1.png">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav mr-auto">

                <li class="nav-item" id = "homenav">
                <a class="nav-link" href="<%=UrlHandling.getDomain()%>/home">Home</a>
                </li>

                <li class="nav-item" id = "aboutnav">
                <a class="nav-link" href="<%=UrlHandling.getDomain()%>/about">About</a>
                </li>

                </ul>


                <% if(!CookieHandling.userCookieExists(request.getCookies())){ %>
                <div class="nav-item">
                <a class="nav-link" href="<%=UrlHandling.getDomain()%>/login">
                Login
                </a>
                </div>
                <% }else{ %>
                <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%=CookieHandling.getUserEmail(request.getCookies())%>
                </a>
                <div class="dropdown-menu mr-5" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="<%=UrlHandling.getDomain()%>/profile">Profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<%=UrlHandling.getDomain()%>/logout">Log out</a>
                </div>
                </div>
                <% } %>

                </div>
                </nav>