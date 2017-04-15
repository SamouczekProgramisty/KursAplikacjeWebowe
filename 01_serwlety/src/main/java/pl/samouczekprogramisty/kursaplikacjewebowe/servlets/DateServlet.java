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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DateTime now = DateTime.now();
        PrintWriter responseOutput = response.getWriter();
        responseOutput.append("<html><body>" + now.toString() + "</body></html>");
    }
}
