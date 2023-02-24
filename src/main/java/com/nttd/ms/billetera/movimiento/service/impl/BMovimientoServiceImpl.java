package com.nttd.ms.billetera.movimiento.service.impl;

import com.nttd.ms.billetera.movimiento.entity.BMovimiento;
import com.nttd.ms.billetera.movimiento.repository.BMovimientoRepository;
import com.nttd.ms.billetera.movimiento.service.BMovimientoService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class BMovimientoServiceImpl implements BMovimientoService {

    @Inject
    BMovimientoRepository bMovimientoRepository;

    @Override
    public Uni<List<BMovimiento>> buscarXCelular(String celular) {
        return bMovimientoRepository.listAll()
                .onItem()
                .<BMovimiento>disjoint().map(bMovimiento -> {
                    BMovimiento bm = new BMovimiento();
                    if(bMovimiento.getCelular().equals(celular)) {
                        bm = bMovimiento;
                    }
                    return bm;
                }).collect().asList();
    }

    @Override
    public Uni<BMovimiento> save(String celular, Double monto, String descripcion, String nombreRazonSocial) {
        return Uni.createFrom().item(new BMovimiento())
                .onItem()
                .transform(bMovimiento -> {
                    bMovimiento.setCelular(celular);
                    bMovimiento.setMonto(monto);
                    bMovimiento.setDescripcion(descripcion);
                    bMovimiento.setNombreRazonSocial(nombreRazonSocial);
                    bMovimiento.setFecha(LocalDate.now());
                    return bMovimiento;
                })
                .call(bMovimiento -> bMovimientoRepository.persist(bMovimiento));
    }

}
