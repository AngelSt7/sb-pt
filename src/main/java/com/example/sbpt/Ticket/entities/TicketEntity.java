package com.example.sbpt.Ticket.entities;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "espacioEstacionamiento_id", nullable = false)
    private EspacioEstacionamientoEntity espacioEstacionamiento;

    @Column(name = "placa_vehiculo", nullable = false)
    private  String placaVehiculo;

    @CreationTimestamp
    @Column(name = "hora_entrada", nullable = false)
    private OffsetDateTime horaEntrada;

    @Column(name = "hora-salida", nullable = true)
    @Builder.Default
    private OffsetDateTime horaSalida = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusTicket", nullable = false)
    @Builder.Default
    private StatusTicket statusTicket = StatusTicket.NO_PAGADO;

    @Column(name = "monto_total", nullable = true)
    @Builder.Default
    private double montoTotal = 0.0;


}
