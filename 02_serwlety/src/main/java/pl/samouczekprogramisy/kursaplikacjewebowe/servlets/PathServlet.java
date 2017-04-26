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
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        responseWriter.write("<html><body>");
        responseWriter.write("<p>ContextPath: " + req.getContextPath() + "</p>");
        responseWriter.write("<p>ServletPath: " + req.getServletPath() + "</p>");
        responseWriter.write("<p>RequestURI: " + req.getRequestURI() + "</p>");
        responseWriter.write("<p>RequestURL: " + req.getRequestURL() + "</p>");
        responseWriter.write("</body></html>");
    }
}
