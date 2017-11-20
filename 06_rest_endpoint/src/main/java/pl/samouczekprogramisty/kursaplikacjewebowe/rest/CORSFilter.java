package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        if (!headers.containsKey("Access-Control-Allow-Origin")) {
            headers.add("Access-Control-Allow-Origin", "*");
        }
        if (!headers.containsKey("Access-Control-Allow-Headers")) {
            headers.add("Access-Control-Allow-Headers", "Content-Type");
        }
        if (!headers.containsKey("Access-Control-Allow-Methods")) {
            headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        }
    }
}
