package com.futbol.controller;

import com.futbol.model.Jugador;
import com.futbol.repository.JugadorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/nuevo")
    public String insertar(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("jugador") Jugador jugador,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        jugadorRepository.save(jugador);
        return "redirect:/jugadores/listar";
    }

    @GetMapping("/listar")
    public String mostrar(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "listar";
    }
}