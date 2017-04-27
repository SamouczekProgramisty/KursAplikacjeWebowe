package pl.samouczekprogramisty.kursaplikacjewebowe.webxml.annotations;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AnnotationConfiguredListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // skip
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest servletRequest = event.getServletRequest();
        servletRequest.setAttribute("pl.samouczekprogramisty.request.sample.attribute", "annotation listener was here!");
    }
}
