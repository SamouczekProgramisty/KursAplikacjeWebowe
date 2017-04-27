package pl.samouczekprogramisty.kursaplikacjewebowe.webxml.xml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class XMLConfiguredServlet extends HttpServlet {

    @Override
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<html><body>");
        writer.write("<h1>Parametry</h1>");
        request.getParameterMap().forEach((key, value) -> writer.format("<p>%s: %s</p>", key, Arrays.toString(value)));
        writer.write("<h1>Atrybuty</h1>");
        Collections.list(request.getAttributeNames())
                .forEach(attributeName -> writer.format("<p>%s: %s</p>", attributeName, request.getAttribute(attributeName)));
        writer.write("</body></html>");
    }
}
