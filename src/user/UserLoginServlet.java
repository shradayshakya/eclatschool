package user;

import data.UserDB;
import tools.UrlHandling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if(UserDB.userExists(email,password)){
            Cookie emailCookie = new Cookie("useremail",email);
            Cookie passwordCookie = new Cookie("userpassword",password);
            response.addCookie(emailCookie);
            response.addCookie(passwordCookie);
            response.sendRedirect(UrlHandling.getDomain()+"/home");
        }else{
            response.sendRedirect(UrlHandling.getDomain()+"/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
