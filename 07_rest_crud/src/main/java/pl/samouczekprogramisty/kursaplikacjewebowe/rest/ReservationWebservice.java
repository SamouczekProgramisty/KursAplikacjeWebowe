package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationWebservice {

    @Inject
    @SuppressWarnings("unused")
    private ReservationDAO dao;

    @GET
    public Response listReservations() {
        return Response.ok(dao.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getReservation(@PathParam("id") @Min(0) Integer id) {
        Reservation reservation = dao.getById(id);
        if (reservation != null) {
            return Response.ok(reservation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    public Response updateReservation(@PathParam("id") @Min(0) Integer id, @Valid Reservation reservation) {
        boolean hasReservation = dao.getById(id) != null;
        if (hasReservation) {
            dao.updateReservation(id, reservation);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReservation(@PathParam("id") @Min(0) Integer id) {
        Reservation reservation = dao.deleteReservation(id);
        if (reservation != null) {
            return Response.ok(reservation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createReservation(@Valid Reservation reservation) {
        int newId = dao.createReservation(reservation);
        URI location;
        try {
            location = new URI("reservations/" + newId);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return Response.created(location).build();
    }
}
