package com.ativ.atividade2.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "venda")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "carro é obrigatório")
    @ManyToOne(optional = false)
    @JoinColumn(name = "carro_id")
    private CarroEntity carro;

    @NotNull(message = "usuário é obrigatório")
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @NotBlank(message = "cpf é obrigatório")
    private String cpf;

    @NotBlank(message = "rg é obrigatório")
    private String rg;

    @NotBlank(message = "numero é obrigatório")
    private String numero;

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotNull(message = "valor é obrigatório")
    private BigDecimal valor;

    @NotBlank(message = "método de pagamento é obrigatório")
    private String metodoPagamento;

    private LocalDateTime dataVenda;

    @PrePersist
    public void prePersist() {
        if (dataVenda == null) {
            dataVenda = LocalDateTime.now();
        }
    }
}
