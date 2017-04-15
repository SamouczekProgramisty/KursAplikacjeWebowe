package pl.samouczekprogramisty.kursaplikacjewebowe.filters.chaining;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/chainingServlet", servletNames = "someRandomServletName")
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1 before");
        request.setAttribute("filter1", "filter1Value");
        chain.doFilter(request, response);
        System.out.println("Filter1 after");
    }

    @Override
    public void destroy() {
    }
}
