
package com.ativ.atividade2.controller;


import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.service.CarroService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/carro")

public class ProjetoController {

    @Autowired

    CarroService carroService;

    @GetMapping("/lista")

    public ResponseEntity<List> getAllCarros() {
        List<CarroEntity> carros = carroService.listarTodosCarros();
        return new ResponseEntity<>(carros, HttpStatus.OK);

    }
    @GetMapping("/pesquisar/{id}")

    public ResponseEntity<CarroEntity> getCarroById(@PathVariable Integer id) {
        CarroEntity carro = carroService.getCarroId(id);
        return new ResponseEntity<>(carro, HttpStatus.OK);

    }

    @PostMapping("/registro")

    public ResponseEntity<CarroEntity> addCarro(@RequestBody CarroEntity fil) {

        var novoCarro = carroService.criarCarro(fil);

        return new ResponseEntity<>(novoCarro, HttpStatus.CREATED);

    }
    

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarCarro(@PathVariable Integer id) {

        carroService.deletarCarro(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
