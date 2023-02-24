package com.nttd.ms.billetera.movimiento.repository;

import com.nttd.ms.billetera.movimiento.entity.BMovimiento;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BMovimientoRepository implements ReactivePanacheMongoRepository<BMovimiento> {
}
