package com.suporte.sistemasuporte.repository;

import com.suporte.sistemasuporte.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

    List<Chamado> findByEstadoChamado(String estadoChamado);

    List<Chamado> findByAtendenteId(Long atendenteId);

    void deleteByAtendenteId(Long id);
}
