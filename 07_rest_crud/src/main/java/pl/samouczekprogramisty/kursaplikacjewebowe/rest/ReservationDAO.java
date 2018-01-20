package pl.samouczekprogramisty.kursaplikacjewebowe.rest;


import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ReservationDAO {

    private final Map<Integer, Reservation> reservations;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public ReservationDAO() {
        Reservation reservation = new Reservation();
        reservation.setName("test");
        reservation.setStart(LocalDateTime.now());
        reservations = Collections.synchronizedMap(new TreeMap<>());
        reservations.put(lastId.getAndIncrement(), reservation);

    }

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
