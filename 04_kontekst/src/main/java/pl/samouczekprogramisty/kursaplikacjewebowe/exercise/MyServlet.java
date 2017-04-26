package pl.samouczekprogramisty.kursaplikacjewebowe.exercise;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/serwlet")
public class MyServlet extends HttpServlet {

    @Override
    // By ANY means that's not the way of creating views!
    // But until we reach JSP I'll stick to it.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        ServletContext context = req.getServletContext();
        setAttributesFromRequest(req);
        Enumeration<String> attributeNames = context.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            writer.write("<p>" + attributeName + ": " + context.getAttribute(attributeName) + "<p>");
        }
        writer.write("</html></body>");
    }

    private void setAttributesFromRequest(HttpServletRequest req) {
        ServletContext context = req.getServletContext();
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            String[] parameterValues = entry.getValue();
            if (parameterValues.length == 1) {
                context.setAttribute(entry.getKey(), parameterValues[0]);
            }
            else {
                context.setAttribute(entry.getKey(), parameterValues);
            }
        }

    }
}
