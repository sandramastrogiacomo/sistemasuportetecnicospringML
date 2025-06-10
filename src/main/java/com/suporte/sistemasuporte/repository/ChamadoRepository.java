package com.suporte.sistemasuporte.repository;

import com.suporte.sistemasuporte.model.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long> {

    List<ChamadoModel> findByEstadoChamado(String estadoChamado);

    List<ChamadoModel> findByAtendenteId(Long atendenteId);

    void deleteByAtendenteId(Long id);
}
