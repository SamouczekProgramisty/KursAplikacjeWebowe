package pl.samouczekprogramisy.kursaplikacjewebowe.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    private static final String VISIT_COUNTER_ATTR = "visitCounter";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        // By ANY means that's not the way of generating views.
        // It's just here as an example, referr to JSP to see how to prepare basic views in a better way.
        responseWriter.write("<html><body>");

        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            responseWriter.write("<p>" + attributeName + ": " + session.getAttribute(attributeName) + "</p>");
        }
        responseWriter.write("</body></html>");

        increaseVisitCounter(session);
    }

    private void increaseVisitCounter(HttpSession session) {
        Object counter = session.getAttribute(VISIT_COUNTER_ATTR);
        Integer numberOfVisits;
        if (counter != null) {
            numberOfVisits = (Integer) counter + 1;
        }
        else {
            numberOfVisits = 1;
        }
        session.setAttribute(VISIT_COUNTER_ATTR, numberOfVisits);
    }
}
