package pl.samouczekprogramisty.kursaplikacjewebowe.rest;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LocalDateTimeConverterTest {

    private LocalDateTimeConverter converter;

    private static final LocalDateTime DATE_REPRESENTATION = LocalDateTime.of(2018, 1, 20, 19, 56);
    private static final String STRING_REPRESENTATION = "2018-01-20T19:56:00";

    @Before
    public void setUp() {
        converter = new LocalDateTimeConverter();
    }

    @Test
    public void shouldBeAbleToCreateDateTimeFromString() {
        assertThat(converter.fromString(STRING_REPRESENTATION), is(DATE_REPRESENTATION));
    }

    @Test
    public void shouldBeAbleToCreateStringFromDateTime() {
        assertThat(converter.toString(DATE_REPRESENTATION), is(STRING_REPRESENTATION));
    }
}