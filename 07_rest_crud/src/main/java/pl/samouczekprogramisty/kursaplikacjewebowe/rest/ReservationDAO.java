package pl.samouczekprogramisty.kursaplikacjewebowe.rest;


import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ReservationDAO {

    private final Map<Integer, Reservation> reservations = Collections.synchronizedMap(new TreeMap<>());;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public Collection<Reservation> getAll() {
        return reservations.values();
    }

    public Reservation getById(Integer id) {
        return reservations.get(id);
    }

    public Reservation updateReservation(Integer id, Reservation reservation) {
        return reservations.put(id, reservation);
    }

    public Reservation deleteReservation(Integer id) {
        return reservations.remove(id);
    }

    public int createReservation(Reservation reservation) {
        int id = lastId.getAndIncrement();
        reservations.put(id, reservation);
        return id;
    }
}
