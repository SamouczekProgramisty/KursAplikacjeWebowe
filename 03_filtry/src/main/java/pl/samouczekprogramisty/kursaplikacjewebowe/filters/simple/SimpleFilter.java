package pl.samouczekprogramisty.kursaplikacjewebowe.filters.simple;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "simpleServletName")
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("before");
        request.setAttribute("simpleServletAttribute", "simpleServlet");
        chain.doFilter(request, response);
        System.out.println("after");
    }

    @Override
    public void destroy() {
    }
}
