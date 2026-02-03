package com.ativ.atividade2.controller;

import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.data.StatusCarro;
import com.ativ.atividade2.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontController {

    private final CarroService carroService;

    public FrontController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PreAuthorize("hasAnyRole('GERENTE','VENDEDOR')")
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("listaCarros", carroService.listarTodosCarros());
        return "index";
    }

    @PreAuthorize("hasAnyRole('GERENTE','VENDEDOR')")
    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("listaCarros", carroService.listarTodosCarros());
        return "lista";
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping("/carro/status/{id}")
    public String atualizarStatus(@PathVariable Integer id, @RequestParam("status") StatusCarro status) {
        carroService.atualizarStatus(id, status);
        return "redirect:/lista";
    }

    @PreAuthorize("hasRole('GERENTE')")
    @GetMapping("/criarCarroForm")
    public String criarFormulario(Model model) {
        CarroEntity carro = new CarroEntity();
        carro.setStatus(StatusCarro.DISPONIVEL);
        model.addAttribute("carro", carro);
        model.addAttribute("statusOpcoes", new StatusCarro[]{StatusCarro.DISPONIVEL, StatusCarro.INDISPONIVEL});
        return "registro";
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping("/salvarCarro")
    public String salvarCarro(@Valid @ModelAttribute("carro") CarroEntity carro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusOpcoes", new StatusCarro[]{StatusCarro.DISPONIVEL, StatusCarro.INDISPONIVEL});
            return "registro";
        }
        carroService.criarCarro(carro);
        return "redirect:/index";
    }
}
