package com.suporte.sistemasuporte.repository;

import com.suporte.sistemasuporte.model.AtendenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository  extends JpaRepository<AtendenteModel, Long> {

}
