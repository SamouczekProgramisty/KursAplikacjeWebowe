package pl.samouczekprogramisty.kursaplikacjewebowe.webxml.annotations;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "my-filter", servletNames = "my-servlet", urlPatterns = "/servlet-url-annotations")
public class AnnotationConfiguredFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // skip
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("filterOut") == null) {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // skip
    }
}
