package user;

import tools.UrlHandling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            if(name.equals("useremail")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect(UrlHandling.getDomain()+"/home");
    }
}
