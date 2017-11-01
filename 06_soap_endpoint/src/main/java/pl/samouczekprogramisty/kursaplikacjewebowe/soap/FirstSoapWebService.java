package pl.samouczekprogramisty.kursaplikacjewebowe.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalTime;

@WebService()
public class FirstSoapWebService {

    @WebMethod
    public String time() {
        return LocalTime.now().toString();
    }

}
