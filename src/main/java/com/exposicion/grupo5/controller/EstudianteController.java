package com.exposicion.grupo5.controller;

import com.exposicion.grupo5.entity.Estudiante;
import com.exposicion.grupo5.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/estudiantes")
// Permite llamar por la url
public class EstudianteController {
 @Autowired
 private EstudianteService estudianteService;
 @GetMapping
 public List<Estudiante> mostrar(String id){
     return estudianteService.mostrar(id);
 }



 @PostMapping
 public Estudiante insertar(@RequestBody Estudiante estudiante){
 return estudianteService.insertar(estudiante);
 }

@PutMapping
 public Estudiante actualizar(@RequestBody Estudiante estudiante){
  return  estudianteService.actualizar(estudiante);
 }

 @DeleteMapping
 public void eliminar(@RequestBody Estudiante emp) {
  estudianteService.eliminar(emp);
 }





}