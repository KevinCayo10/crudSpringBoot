package com.exposicion.grupo5.controller;

import com.exposicion.grupo5.entity.Estudiante;
import com.exposicion.grupo5.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EstudianteController1 {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public String mostrar(Model model) {
        List<Estudiante> estudiantes = estudianteService.mostrar();
        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable("id") String id, Model model){
        List<Estudiante> estudiantes = estudianteService.buscar(id);
        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }


    @GetMapping("/nuevo-estudiante")
    public String nuevo(Estudiante estudiante) {
        return "agregar";
    }

    @PostMapping("/accion-nuevo")
    public String insertar(@Validated Estudiante estudiante, BindingResult result, Model model) {
        estudianteService.insertar(estudiante);
        return "redirect:/";
    }

    @GetMapping("/editar-estudiante/{id}")
    public String editar(@PathVariable("id") String id, Model model) {
        Estudiante e = estudianteService.buscarPorId(id);
        model.addAttribute("estudiante", e);
        return "editar";
    }

    @PostMapping("/accion-editar/{id}" )
    public String actualizar(@PathVariable("id") String id, @Validated Estudiante estudiante, BindingResult result, Model model) {
        estudianteService.actualizar(estudiante);
        return "redirect:/";
    }

    @GetMapping("/eliminar-estudiante/{id}")
    public String eliminar(@PathVariable("id") String id, Model model) {
        Estudiante e = estudianteService.buscarPorId(id);
        estudianteService.eliminar(e);
        return "redirect:/";
    }




}
