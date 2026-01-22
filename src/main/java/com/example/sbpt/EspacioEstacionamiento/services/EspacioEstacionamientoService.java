package com.example.sbpt.EspacioEstacionamiento.services;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import com.example.sbpt.EspacioEstacionamiento.ports.EspacioEstacionamientoRepoPort;
import com.example.sbpt.EspacioEstacionamiento.repositories.EspacioEstacionamientoRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EspacioEstacionamientoService {

    private final EspacioEstacionamientoRepoPort espacioEstacionamientoRepoPort;

    List<EspacioEstacionamientoEntity> espacios = new ArrayList<>(
            List.of(
                    new EspacioEstacionamientoEntity("A-1", false, 0.05),
                    new EspacioEstacionamientoEntity("A-2", false, 0.05),
                    new EspacioEstacionamientoEntity("A-3", true, 0.06),
                    new EspacioEstacionamientoEntity("B-1", false, 0.07),
                    new EspacioEstacionamientoEntity("B-2", true, 0.07),
                    new EspacioEstacionamientoEntity("B-3", false, 0.08),
                    new EspacioEstacionamientoEntity("C-1", false, 0.10),
                    new EspacioEstacionamientoEntity("C-2", true, 0.10),
                    new EspacioEstacionamientoEntity("C-3", false, 0.12),
                    new EspacioEstacionamientoEntity("D-1", false, 0.15)
            )
    );


    public void seed() {
        espacioEstacionamientoRepoPort.seed(espacios);
    }

    public List<EspacioEstacionamientoEntity> list(){
        return  espacioEstacionamientoRepoPort.findAll();
    }
}
