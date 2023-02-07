package com.exposicion.grupo5.service;

import com.exposicion.grupo5.entity.Estudiante;
import com.exposicion.grupo5.repository.EstudianteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    /* permite inyectar informacion desde nuestro servicio a nuestro repositorio*/
    private EstudianteRepo estudianteRepo;

    public List<Estudiante> mostrar(){
        return estudianteRepo.findAll();
    }

    public List<Estudiante> buscar(String id){return estudianteRepo.SearchByCedula(id);}

    public Estudiante insertar(Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }

    public Estudiante actualizar(Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }

    public void eliminar(Estudiante est) {
        estudianteRepo.delete(est);
    }

    public Estudiante buscarPorId(String id) {
        return estudianteRepo.findByCedula(id);
    }



}
