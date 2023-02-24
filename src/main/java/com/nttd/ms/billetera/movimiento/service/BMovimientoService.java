package com.nttd.ms.billetera.movimiento.service;

import com.nttd.ms.billetera.movimiento.entity.BMovimiento;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface BMovimientoService {

    Uni<List<BMovimiento>> buscarXCelular(String celular);

    Uni<BMovimiento> save(String celular, Double monto, String descripcion);
}
