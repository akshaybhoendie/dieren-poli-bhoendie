package sr.unasat.library.controller;

import sr.unasat.library.dto.DienstDto;
import sr.unasat.library.dto.DienstDto;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.service.DienstService;
import sr.unasat.library.service.impl.DienstServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dienst")
public class DienstController {

    private DienstService dienstService = new DienstServiceImpl();

    @Path("/actieve-diensten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DienstDto> actieveDiensten() {
        return dienstService.activeDiensten();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DienstDto add(DienstDto dienstDto) { return dienstService.createDienst(dienstDto);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DienstDto update(DienstDto dienstDto) { return dienstService.updateDienst(dienstDto);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(Long lidmaatschapId) {
        return dienstService.deleteDienst(lidmaatschapId);
    }

    @Path("/find-by-id")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DienstDto findDienstById(DienstDto dienstDto) {
        return dienstService.findDienstById(dienstDto.getId());
    }
}
