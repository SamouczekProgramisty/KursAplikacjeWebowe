package pl.samouczekprogramisy.kursaplikacjewebowe.serwlety.exercise;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/exercise")
public class ExerciseServlet extends HttpServlet {

    private static final String TOTAL_COUNT = "totalCount";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int requestSum = sumNumberParams(req);
        int totalSum = updateTotalSum(req, requestSum);
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.write("<html><body>");
        responseWriter.write("<p>requestSum: " + requestSum + "</p>");
        responseWriter.write("<p>totalSum: " + totalSum + "</p>");
        responseWriter.write("</html></body>");
    }

    private int sumNumberParams(HttpServletRequest req) {
        int requestSum = 0;
        for (Map.Entry<String, String[]> parameters : req.getParameterMap().entrySet()) {
            for (String paramValue : parameters.getValue()) {
                try {
                    requestSum += Integer.parseInt(paramValue);
                }
                catch (NumberFormatException e) {
                    // ignore
                }
            }
        }
        return requestSum;
    }

    private int updateTotalSum(HttpServletRequest req, int requestSum) {
        HttpSession session = req.getSession();
        Object counter = session.getAttribute("totalCount");
        Integer totalCount = requestSum;
        if (counter != null) {
            totalCount += (Integer) counter;
        }
        session.setAttribute(TOTAL_COUNT, totalCount);
        return totalCount;
    }
}
