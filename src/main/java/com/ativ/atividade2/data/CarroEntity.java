package com.ativ.atividade2.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "carro")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;

    @NotBlank(message = "marca não pode estar em branco")
    private String marca;

    @NotBlank(message = "ano não pode estar em branco")
    private String ano;

    @NotBlank(message = "cor não pode estar em branco")
    private String cor;

    @NotNull(message = "status não pode estar vazio")
    @Enumerated(EnumType.STRING)
    private StatusCarro status;

    @Column(name = "disponivel", length = 3)
    private String disponivel;


    @PrePersist
    @PreUpdate
    private void syncDisponivel() {
        if (status == null) {
            status = StatusCarro.DISPONIVEL;
        }
        this.disponivel = (status == StatusCarro.DISPONIVEL) ? "Sim" : "Não";
    }

}
