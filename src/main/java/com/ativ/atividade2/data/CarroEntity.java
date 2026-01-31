
package com.ativ.atividade2.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 

@Entity 

@Table(name="Carro") 
public class CarroEntity {


@Id 

@GeneratedValue(strategy = GenerationType.AUTO)

private Integer id; 


@NotBlank(message="titulo não pode estar em branco") 

private String modelo; 


@NotBlank(message="marca não pode estar em branco") 

private String marca; 

@NotBlank(message="ano não pode estar em branco") 

private String ano; 

@NotBlank(message="disponivel não pode estar em branco") 

private String disponivel;




} 

