package com.ativ.atividade2.service;

import com.ativ.atividade2.data.*;
import com.ativ.atividade2.exception.ResourceNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final CarroService carroService;
    private final UsuarioRepository usuarioRepository;

    public VendaService(VendaRepository vendaRepository, CarroService carroService, UsuarioRepository usuarioRepository) {
        this.vendaRepository = vendaRepository;
        this.carroService = carroService;
        this.usuarioRepository = usuarioRepository;
    }

    public List<VendaEntity> listarHistorico() {
        return vendaRepository.findAllByOrderByDataVendaDesc();
    }

    @Transactional
    public VendaEntity realizarVenda(
            Integer carroId,
            String loginUsuario,
            String cpf,
            String rg,
            String numero,
            String nome,
            BigDecimal valor,
            String metodoPagamento
    ) {
        CarroEntity carro = carroService.getCarroId(carroId);

        if (carro.getStatus() != StatusCarro.DISPONIVEL) {
            throw new IllegalStateException("O carro não está disponível para venda.");
        }

        UsuarioEntity usuario = usuarioRepository.findByLogin(loginUsuario)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + loginUsuario));

        VendaEntity venda = new VendaEntity();
        venda.setCarro(carro);
        venda.setUsuario(usuario);
        venda.setCpf(cpf);
        venda.setRg(rg);
        venda.setNumero(numero);
        venda.setNome(nome);
        venda.setValor(valor);
        venda.setMetodoPagamento(metodoPagamento);

        // salvar a venda
        VendaEntity salva = vendaRepository.save(venda);

        // marcar carro como vendido
        carroService.atualizarStatus(carro.getId(), StatusCarro.VENDIDO);

        return salva;
    }
}
