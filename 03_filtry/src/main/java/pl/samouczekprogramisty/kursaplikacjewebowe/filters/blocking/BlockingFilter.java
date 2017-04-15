package pl.samouczekprogramisty.kursaplikacjewebowe.filters.blocking;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


@WebFilter("/blockedServlet")
public class BlockingFilter implements Filter{

    private static final String BLOCK = "blokuj";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        for (Map.Entry<String, String[]> parameter : httpRequest.getParameterMap().entrySet()) {
            for (String parameterValue : parameter.getValue()) {
                if (parameterValue.equals(BLOCK)) {
                    response.getWriter().write("<html><body>Zablokowane!</body></head>");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
