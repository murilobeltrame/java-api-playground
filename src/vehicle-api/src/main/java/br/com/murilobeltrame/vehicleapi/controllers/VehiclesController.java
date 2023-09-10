package br.com.murilobeltrame.vehicleapi.controllers;

import br.com.murilobeltrame.vehicleapi.models.VehicleCreateRequest;
import br.com.murilobeltrame.vehicleapi.models.VehicleListResponse;
import br.com.murilobeltrame.vehicleapi.models.VehicleResponse;
import br.com.murilobeltrame.vehicleapi.models.VehicleUpdateRequest;
import br.com.murilobeltrame.vehicleapi.utils.ResourceUri;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehiclesController {
    private static final String NONEXISTENT_LICENSE_PLATE = "ABC1234";

    private Response notFound() {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    private Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private boolean cantFind(String id) {
        return
                id.isEmpty() ||
                        Objects.equals(id, NONEXISTENT_LICENSE_PLATE);
    }

    private boolean missingRequiredData(VehicleCreateRequest request) {
        return request.getLicensePlate().isEmpty() ||
                request.getBrand().isEmpty() ||
                request.getModel().isEmpty();
    }

    private boolean missingRequiredData(VehicleUpdateRequest request) {
        return request.getBrand().isEmpty() ||
                request.getModel().isEmpty();
    }

    @GET
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = VehicleListResponse.class)))
    public Response fetch() {
        List<VehicleResponse> vehicles = Arrays.asList(
                new VehicleResponse("AAA1234", "Volvo", "FH Globetrotter"),
                new VehicleResponse("BBB4321", "Iveco", "S-Way"),
                new VehicleResponse("CCC4312", "Mercedes-Benz", "Axor")
        );
        return Response.ok(vehicles).build();
    }

    @POST
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = VehicleResponse.class))),
            @ApiResponse(responseCode = "400")
    })
    public Response create(VehicleCreateRequest request) {
        if (missingRequiredData(request)) return badRequest();
        VehicleResponse response = VehicleResponse.from(request);
        URI location = ResourceUri.getLocationURI(response.getLicensePlate());
        return Response.created(location).entity(response).build();
    }

    @GET
    @Path("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = VehicleResponse.class))),
            @ApiResponse(responseCode = "404")
    })
    public Response get(@PathParam("id") String id) {
        if (cantFind(id)) return notFound();
        return Response.ok(new VehicleResponse(id, "Volvo", "FH Globetrotter")).build();
    }

    @PUT
    @Path("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
    })
    public Response update(@PathParam("id") String id, VehicleUpdateRequest request) {
        if (cantFind(id)) return notFound();
        if (missingRequiredData(request)) return badRequest();
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404"),
    })
    public  Response delete(@PathParam("id") String id) {
        if (cantFind(id)) return notFound();
        return Response.noContent().build();
    }
}
