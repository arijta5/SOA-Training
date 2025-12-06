package webservices;

import entities.Module;
import entities.UniteEnseignement;
import metiers.ModuleBusiness;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Module")
public class ModuleWS {
    ModuleBusiness helper = new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        return Response.status(200).entity(helper.getAllModules()).build();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addModule(Module module) {
        if (helper.addModule(module) == true) {
            return Response.status(201).entity("module added").build();
        } else return Response.status(400).entity("module not added").build();
    }

    @Path("/update/{matricule}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateModule(@PathParam("matricule") String matricule, Module updatedModule) {

        boolean ok = helper.updateModule(matricule, updatedModule);

        if (ok) {
            return Response.ok("module updated").build();
        }
        return Response.status(404).entity("Module not found").build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("id") String matricule) {

        if (helper.deleteModule(matricule)) {
            return Response.ok("module deleted").build();
        }
        return Response.status(404).entity("Module not found").build();
    }
}