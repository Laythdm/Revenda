package com.ativ.atividade2.service;

import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.data.CarroRepository;
import com.ativ.atividade2.data.StatusCarro;
import com.ativ.atividade2.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<CarroEntity> listarTodosCarros() {
        return carroRepository.findAll();
    }

    public List<CarroEntity> listarCarrosDisponiveis() {
        return carroRepository.findByStatus(StatusCarro.DISPONIVEL);
    }

    public CarroEntity getCarroId(Integer id) {
        return carroRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado: " + id));
    }

    public CarroEntity criarCarro(CarroEntity carro) {
        if (carro.getStatus() == null) {
            carro.setStatus(StatusCarro.DISPONIVEL);
        }

        preencherCorSeVazia(carro);

        return carroRepository.save(carro);
    }

    public CarroEntity atualizarStatus(Integer id, StatusCarro status) {
        CarroEntity carro = getCarroId(id);
        carro.setStatus(status);

        preencherCorSeVazia(carro);

        return carroRepository.save(carro);
    }

    private void preencherCorSeVazia(CarroEntity carro) {
        if (carro.getCor() == null || carro.getCor().trim().isEmpty()) {
            carro.setCor("Não informado");
        }
    }

    public void deletarCarro(Integer id) {
        CarroEntity carro = getCarroId(id);
        carroRepository.deleteById(carro.getId());
    }
}
