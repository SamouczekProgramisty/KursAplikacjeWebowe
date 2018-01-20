package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import org.apache.johnzon.mapper.Converter;
import pl.samouczekprogramisty.kursaplikacjewebowe.rest.exceptions.ReservationException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {


    private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public String toString(LocalDateTime instance) {
        return formatter.format(instance);
    }

    @Override
    public LocalDateTime fromString(String text) {
        try {
            return LocalDateTime.parse(text, formatter);
        } catch (DateTimeParseException e) {
            throw new ReservationException(String.format("Passed date `%s` couldn't parsed!", text));
        }
    }
}
