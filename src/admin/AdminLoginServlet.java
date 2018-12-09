package admin;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import data.AdminDB;
import tools.UrlHandling;


public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(AdminDB.adminExists(email,password)){
            Cookie emailCookie = new Cookie("email",email);
            Cookie passwordCookie = new Cookie("password",password);
            response.addCookie(emailCookie);
            response.addCookie(passwordCookie);
            response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/");
        }else{
            response.sendRedirect(UrlHandling.getDomain()+"/adminpanel/loginadmin");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/adminpanel/loginAdmin.jsp").forward(request,response);
    }
}
