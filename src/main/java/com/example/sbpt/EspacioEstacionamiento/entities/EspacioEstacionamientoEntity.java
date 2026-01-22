package com.example.sbpt.EspacioEstacionamiento.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "espacio-estacionamiento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EspacioEstacionamientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "codigo", nullable = false)
    private boolean ocupado;

    @Column(name = "tarifa_por_minuto", nullable = false)
    private double tarifaPorMinuto;

    public EspacioEstacionamientoEntity(String codigo, boolean ocupado, double tarifaPorMinuto) {
        this.codigo = codigo;
        this.ocupado = ocupado;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }
}
