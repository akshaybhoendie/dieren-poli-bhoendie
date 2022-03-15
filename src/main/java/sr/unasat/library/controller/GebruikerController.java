package sr.unasat.library.controller;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.service.GebruikerService;
import sr.unasat.library.service.impl.GebruikerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("gebruiker")
public class GebruikerController {

    private GebruikerService gebruikerService = new GebruikerServiceImpl();

    @Path("/actieve-gebruikers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gebruiker> activeGebruikers() {
        return gebruikerService.activeGebruikers();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GebruikerDto add(GebruikerDto gebruikerDto) {
        return gebruikerService.createGebruiker(gebruikerDto);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GebruikerDto update(GebruikerDto gebruikerDto) {
        return gebruikerService.updateGebruiker(gebruikerDto);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(Long gebruikerId) {
        return gebruikerService.deleteGebruiker(gebruikerId);
    }

    @Path("/find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GebruikerDto findGebruiker(GebruikerDto gebruiker) {
        return gebruikerService.findGebruikerById(gebruiker.getId());
    }
}
