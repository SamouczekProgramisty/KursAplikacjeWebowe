package pl.samouczekprogramisy.kursaplikacjewebowe.serwlety;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();

        // By ANY means that's not the way of generating views.
        // It's just here as an example, referr to JSP to see how to prepare basic views in a better way.
        responseWriter.write("<html><body>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(headerName);
            while (headerValues.hasMoreElements()) {
                String headerValue = headerValues.nextElement();
                responseWriter.write("<p>" + headerName + ": " + headerValue + "</p>");
            }
        }

        resp.addHeader("my-custom-header", "value1");
        resp.addHeader("my-custom-header", "valued");
        resp.setIntHeader("my-custom-int-header", 123);

        responseWriter.write("</body></html>");
    }
}
