package pl.samouczekprogramisty.kursaplikacjewebowe.filters.blocking;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/blockedServlet")
public class BlockedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.write("<html><body>");
        writer.write("<p>Bum!</p>");
        for (Map.Entry<String, String[]> parameter : req.getParameterMap().entrySet()) {
            writer.write("<p>" + parameter.getKey() + ": " + Arrays.toString(parameter.getValue()) + "</p>");
        }
        writer.write("</html></body>");
    }
}
