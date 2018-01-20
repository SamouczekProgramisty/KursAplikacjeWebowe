package pl.samouczekprogramisty.kursaplikacjewebowe.rest.exceptions;

import javax.ws.rs.core.Response;

public class ReservationException extends RuntimeException {

    private final int statusCode;

    private final String responseMessage;

    public ReservationException(String responseMessage) {
        this(Response.Status.BAD_REQUEST.getStatusCode(), responseMessage);
    }

    public ReservationException(int statusCode, String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

}
