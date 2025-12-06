package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UniteEnsWS {
    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response
                .status(200)
                .entity(helper.getListeUE())
                .build();
    }

}
