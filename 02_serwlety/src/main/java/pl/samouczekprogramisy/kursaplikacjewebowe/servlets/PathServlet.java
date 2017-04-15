package pl.samouczekprogramisy.kursaplikacjewebowe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/path")
public class PathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        // By ANY means that's not the way of generating views.
        // It's just here as an example, referr to JSP to see how to prepare basic views in a better way.
        responseWriter.write("<html><body>");
        responseWriter.write("<p>ContextPath: " + req.getContextPath() + "</p>");
        responseWriter.write("<p>ServletPath: " + req.getServletPath() + "</p>");
        responseWriter.write("<p>RequestURI: " + req.getRequestURI() + "</p>");
        responseWriter.write("<p>RequestURL: " + req.getRequestURL() + "</p>");
        responseWriter.write("</body></html>");
    }
}
