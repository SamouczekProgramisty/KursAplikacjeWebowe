package pl.samouczekprogramisy.kursaplikacjewebowe.serwlety;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/parameters")
public class ParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();
        // By ANY means that's not the way of generating views.
        // It's just here as an example, referr to JSP to see how to prepare basic views in a better way.
        responseWriter.write("<html><body>");
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            responseWriter.write("<p>" + entry.getKey() + ": " + Arrays.toString(entry.getValue()) +"</p>");
        }
        responseWriter.write("</body></html>");
    }
}
