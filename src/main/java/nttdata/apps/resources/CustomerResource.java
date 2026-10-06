package nttdata.apps.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import nttdata.apps.dto.CustomerRequest;
import nttdata.apps.service.CustomerService;


@Path("/api/customers")
public class CustomerResource {

    @Inject
    CustomerService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        var customers = service.findAll();
        if (customers.isEmpty()) {return Response.noContent().build();}

        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByFirstName(@QueryParam("firstName") String firstName,
                                   @QueryParam("lastName") String lastName,
                                   @Context UriInfo uriInfo) {
        if (firstName!=null)
            return Response.ok(service.findByFirstName(firstName)).build();
        if (lastName!=null)
            return Response.ok(service.findByLastName(lastName)).build();
        return Response.ok("¡No se ha insertado algún parámetro!").build();
    }

    @POST
    public Response create(CustomerRequest request){
        return Response.ok(service.create(request)).build();
    }
}
