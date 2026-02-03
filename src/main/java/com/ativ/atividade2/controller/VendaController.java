package com.ativ.atividade2.controller;

import com.ativ.atividade2.data.StatusCarro;
import com.ativ.atividade2.service.CarroService;
import com.ativ.atividade2.service.VendaService;
import java.math.BigDecimal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;
    private final CarroService carroService;

    public VendaController(VendaService vendaService, CarroService carroService) {
        this.vendaService = vendaService;
        this.carroService = carroService;
    }

    @PreAuthorize("hasRole('VENDEDOR')")
    @GetMapping("/nova")
    public String novaVenda(@RequestParam(value = "carroId", required = false) Integer carroId, Model model) {
        model.addAttribute("carrosDisponiveis", carroService.listarCarrosDisponiveis());
        model.addAttribute("carroSelecionado", carroId);
        return "vender";
    }

    @PreAuthorize("hasRole('VENDEDOR')")
    @PostMapping("/confirmar")
    public String confirmarVenda(
            @RequestParam("carroId") Integer carroId,
            @RequestParam("cpf") String cpf,
            @RequestParam("rg") String rg,
            @RequestParam("numero") String numero,
            @RequestParam("nome") String nome,
            @RequestParam("valor") BigDecimal valor,
            @RequestParam("metodoPagamento") String metodoPagamento,
            Authentication authentication
    ) {
        vendaService.realizarVenda(carroId, authentication.getName(), cpf, rg, numero, nome, valor, metodoPagamento);
        return "redirect:/lista";
    }

    @PreAuthorize("hasRole('GERENTE')")
    @GetMapping("/historico")
    public String historico(Model model) {
        model.addAttribute("vendas", vendaService.listarHistorico());
        return "historicoVendas";
    }
}
