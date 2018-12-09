package tools;
import javax.servlet.http.Cookie;
import data.AdminDB;
import data.UserDB;

public class CookieHandling {
    public static boolean adminCookieExists(Cookie[] cookies){
        boolean flag = false;
        String email = "", password = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(!cookie.equals(null)) {
                    if (cookie.getName().equals("email")) {
                        email = cookie.getValue();
                    }
                    else if(cookie.getName().equals("password")){
                        password = cookie.getValue();
                    }

                    if (AdminDB.adminExists(email,password)){
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public static boolean userCookieExists(Cookie[] cookies){
        boolean flag = false;
        String email = "", password = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(!cookie.equals(null)) {
                    if (cookie.getName().equals("useremail")) {
                        email = cookie.getValue();
                    }
                    else if(cookie.getName().equals("userpassword")){
                        password = cookie.getValue();
                    }
                    if (UserDB.userExists(email,password)){
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public static String getUserEmail(Cookie[] cookies){
        String email = "";
        for (Cookie cookie : cookies) {
            if(!cookie.equals(null)) {
                if (cookie.getName().equals("useremail")) {
                    email = cookie.getValue();
                }
            }
        }
        return email;
    }

}
