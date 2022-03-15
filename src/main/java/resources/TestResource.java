/*
package resources;

import sr.unasat.library.dto.Car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestResource {

    @Path("getText")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(){
        return "Works";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJsonText(){
        Car car = new Car("Subaru", "2006");
        String json = "{merk: " + car.getMerk() + ", bouwjaar: " + car.getBouwjaar() + "}";
        return json;
        }
        }
*/
