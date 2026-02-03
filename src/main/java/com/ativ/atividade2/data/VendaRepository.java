package com.ativ.atividade2.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {
    List<VendaEntity> findAllByOrderByDataVendaDesc();
}
