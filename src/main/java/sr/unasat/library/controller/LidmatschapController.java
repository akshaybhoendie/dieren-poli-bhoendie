package sr.unasat.library.controller;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.service.LidmaatschapService;
import sr.unasat.library.service.impl.LidmaatschapServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LidmatschapController {

    private LidmaatschapService lidmaatschapService = new LidmaatschapServiceImpl();

    @Path("/actieve-lidmaatschappen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lidmaatschap> actieveLidmaatschappen() {
        return lidmaatschapService.activeLidmaatschappen();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LidMaatschapDto add(LidMaatschapDto lidmaatschapDto) { return lidmaatschapService.createLidmaatschap(lidmaatschapDto);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LidMaatschapDto update(LidMaatschapDto lidmaatschap) { return lidmaatschapService.updateLidmatschap(lidmaatschap);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(Long lidmaatschapId) {
        return lidmaatschapService.deleteLidmatschap(lidmaatschapId);
    }

    @Path("/find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LidMaatschapDto findGebruiker(LidMaatschapDto lidMaatschapDto) {
        return lidmaatschapService.findLidmatschapById(lidMaatschapDto.getId());
    }
}
