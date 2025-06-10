package com.suporte.sistemasuporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suporte.sistemasuporte.model.BalcaoAtendimentoModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BalcaoAtendimentoRepository extends JpaRepository<BalcaoAtendimentoModel, Long> {
}
