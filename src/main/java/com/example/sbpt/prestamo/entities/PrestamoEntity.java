package com.example.sbpt.prestamo.entities;

import com.example.sbpt.libro.entities.LibroEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "libro")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", nullable = false)
    private LibroEntity libro;

    @Column(name = "alumno_id", nullable = false)
    private UUID alumnoId;

    @CreationTimestamp
    private OffsetDateTime fechaPrestamo;

    @UpdateTimestamp
    private OffsetDateTime fechaDevolucion;
}
