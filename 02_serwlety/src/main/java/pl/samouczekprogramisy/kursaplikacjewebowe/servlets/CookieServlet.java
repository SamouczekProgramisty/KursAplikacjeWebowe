package pl.samouczekprogramisy.kursaplikacjewebowe.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    @Override
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        responseWriter.write("<html><body>");
        for (Cookie cookie : req.getCookies()) {
            responseWriter.write("<p>" + cookie.getName() + " " + cookie.getValue() + "</p>");
        }

        Cookie cookie = new Cookie("custom-cookie", "bum bum cyk cyk");
        cookie.setMaxAge(10);
        resp.addCookie(cookie);

        responseWriter.write("</body></html>");
    }
}
