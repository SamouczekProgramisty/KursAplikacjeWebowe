package pl.samouczekprogramisty.kursaplikacjewebowe.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ReservationExceptionMapper implements ExceptionMapper<ReservationException> {

    public static class ErrorMessage {

        public final String error;

        public ErrorMessage(String error) {
            this.error = error;
        }
    }

    @Override
    public Response toResponse(ReservationException exception) {
        return Response
                .status(exception.getStatusCode())
                .entity(new ErrorMessage(exception.getResponseMessage()))
                .build();
    }
}
