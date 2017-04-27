package pl.samouczekprogramisty.kursaplikacjewebowe.servlets;


import org.joda.time.DateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/date")
public class DateServlet extends HttpServlet {

    @Override
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DateTime now = DateTime.now();
        PrintWriter responseOutput = response.getWriter();
        responseOutput.format("<html><body>%s</body></html>", now.toString());
    }
}
