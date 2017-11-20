package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/reservation")
public class ReservationWebservice {
    @GET
    public Response listReservations() {
        return Response.ok("Oto wszystkie rezerwacje :)").build();
    }

    @GET
    @Path("{id}")
    public Response getReservation(@PathParam("id") Integer id) {
        return Response.ok("Oto rezerwacja o identyfikatorze " + id + " :)").build();
    }

    @POST
    @Path("{id}")
    public Response updateReservation(@PathParam("id") Integer id) {
        return Response.ok("Zmodyfikowaliśmy rezerwację o numerze " + id + " :)").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReservation(@PathParam("id") Integer id) {
        return Response.ok("Usunęliśmy rezerwację o numerze " + id + " :)").build();
    }

    @PUT
    public Response createReservation() {
        return Response.ok("Rezerwacja została utworzona!").build();
    }
}
