package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import org.apache.johnzon.mapper.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {


    private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public String toString(LocalDateTime instance) {
        return formatter.format(instance);
    }

    @Override
    public LocalDateTime fromString(String text) {
        return LocalDateTime.parse(text, formatter);
    }
}
