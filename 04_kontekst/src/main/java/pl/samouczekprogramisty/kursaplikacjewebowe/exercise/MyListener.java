package pl.samouczekprogramisty.kursaplikacjewebowe.exercise;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class MyListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        if (event.getName().endsWith(".when")) {
            return;
        }
        ServletContext context = event.getServletContext();
        context.setAttribute(event.getName() + ".when", new Date());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // do nothing
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // do nothing
    }
}
