
package com.ativ.atividade2.service;

import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.data.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CarroService {

    @Autowired

    CarroRepository carroRepository;

    public CarroEntity criarCarro(CarroEntity fil) {

        fil.setId(null);
        carroRepository.save(fil);
        return fil;

    }

    

    public CarroEntity getCarroId(Integer filId) {
        return carroRepository.findById(filId).orElse(null);
    }

    public List<CarroEntity> listarTodosCarros() {

        return carroRepository.findAll();

    }public void deletarCarro(Integer filId) {

        CarroEntity fil = getCarroId(filId);

        carroRepository.deleteById(fil.getId());

    }


}
