package com.ativ.atividade2.controller;

import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.data.StatusCarro;
import com.ativ.atividade2.service.CarroService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class ProjetoController {

    private final CarroService carroService;

    public ProjetoController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PreAuthorize("hasAnyRole('GERENTE','VENDEDOR')")
    @GetMapping("/lista")
    public ResponseEntity<List<CarroEntity>> getAllCarros() {
        return new ResponseEntity<>(carroService.listarTodosCarros(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('GERENTE','VENDEDOR')")
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<CarroEntity> getCarroById(@PathVariable Integer id) {
        return new ResponseEntity<>(carroService.getCarroId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping("/registro")
    public ResponseEntity<CarroEntity> addCarro(@RequestBody CarroEntity carro) {
        if (carro.getStatus() == null) carro.setStatus(StatusCarro.DISPONIVEL);
        return new ResponseEntity<>(carroService.criarCarro(carro), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('GERENTE')")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Integer id) {
        carroService.deletarCarro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
