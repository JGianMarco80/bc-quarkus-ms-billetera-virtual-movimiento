package com.nttd.ms.billetera.movimiento.resource;

import com.nttd.ms.billetera.movimiento.entity.BMovimiento;
import com.nttd.ms.billetera.movimiento.service.BMovimientoService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/billetera-virtual-movimiento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BMovimientoResource {

    @Inject
    BMovimientoService bMovimientoService;

    @GET
    public Uni<List<BMovimiento>> buscarXCelular(@QueryParam("celular") String celular) {
        return bMovimientoService.buscarXCelular(celular);
    }

    @POST
    @Transactional
    public Uni<BMovimiento> save(@QueryParam("celular") String celular,
                                 @QueryParam("monto") Double monto,
                                 @QueryParam("descripcion") String descripcion) {
        return bMovimientoService.save(celular, monto, descripcion);
    }

}
