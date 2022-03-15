package sr.unasat.library.controller;

import sr.unasat.library.dto.DierDto;
import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.service.DierService;
import sr.unasat.library.service.impl.DierServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class DierController {

    private DierService dierService = new DierServiceImpl();

    @Path("/alle-dieren")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DierDto> getAlleDieren() {
        return dierService.getAllDieren();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DierDto add(DierDto dierDto) { return dierService.createDier(dierDto);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DierDto update(DierDto dierDto) { return dierService.updateDier(dierDto);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(Long lidmaatschapId) {
        return dierService.deleteDier(lidmaatschapId);
    }

    @Path("/find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DierDto findDier(DierDto dierDto) {
        return dierService.findDierById(dierDto.getId());
    }

    @Path("/find-dieren-owner")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<DierDto> findDierenOfLid(Long lidId){
        return dierService.findDierenOfOwnerByOwnerId(lidId);
    }
}
