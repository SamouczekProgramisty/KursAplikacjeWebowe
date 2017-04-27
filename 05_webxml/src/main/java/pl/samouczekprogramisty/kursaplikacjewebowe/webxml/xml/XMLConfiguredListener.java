package pl.samouczekprogramisty.kursaplikacjewebowe.webxml.xml;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class XMLConfiguredListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // skip
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest servletRequest = event.getServletRequest();
        servletRequest.setAttribute("pl.samouczekprogramisty.request.sample.attribute", "xml listener was here!");
    }
}
