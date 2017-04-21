package pl.samouczekprogramisty.kursaplikacjewebowe.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        ServletContext context = req.getServletContext();
        context.setAttribute("pl.samouczekprogramisty.servlet2", "servlet2 attribute");
        Enumeration<String> attributeNames = context.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            writer.write("<p>" + attributeName + ": " + context.getAttribute(attributeName) + "<p>");
        }
        writer.write("</html></body>");
    }
}
