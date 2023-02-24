package com.nttd.ms.billetera.movimiento.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@MongoEntity(collection = "billetera_virtual_movimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMovimiento {

    private ObjectId id;

    private String celular;

    private LocalDate fecha;

    private Double monto;

    private String descripcion;

}
