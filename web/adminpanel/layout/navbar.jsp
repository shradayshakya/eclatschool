</head>
        <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="<%=UrlHandling.getDomain()%>/adminpanel"><img src ="<%=UrlHandling.getDomain()%>/img/eclat1.png" /></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
        <li class="nav-item">
        <a class="nav-link" href="<%=UrlHandling.getDomain()%>/adminpanel/showstudents" id="navStudents">Students</a>
        </li>

        <li class="nav-item">
        <a class="nav-link" href="<%=UrlHandling.getDomain()%>/adminpanel/showcourses" id="navCourses">Courses</a>
        </li>

        <li class="nav-item">
        <a class="nav-link" href="<%=UrlHandling.getDomain()%>/adminpanel/showenrollments" id="navEnrollments">Enrollments</a>
        </li>
        </ul>
        </div>

        <a class="nav-link ml-auto" href="<%=UrlHandling.getDomain()%>/adminpanel/logoutadmin">Logout</a>

        </nav>