package com.ativ.atividade2.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
    List<CarroEntity> findByStatus(StatusCarro status);
}
