package com.suporte.sistemasuporte.service;

import com.suporte.sistemasuporte.dto.AtendenteDTO;
import com.suporte.sistemasuporte.model.AtendenteModel;
import com.suporte.sistemasuporte.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteService {

    private final AtendenteRepository repository;

    public AtendenteService(AtendenteRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private AtendenteRepository atendenteRepository;

    public AtendenteModel create(AtendenteDTO atendenteDTO) {
    AtendenteModel atendente = new AtendenteModel();
    atendente.setNome(atendenteDTO.getNome());
    return atendenteRepository.save(atendente);
    }

    public Page<AtendenteModel> findAll(Pageable pageable) {
        return atendenteRepository.findAll(pageable);
    }
    public boolean delete(Long id) {
        Optional<AtendenteModel> atendenteOptional = atendenteRepository.findById(id);
        if (atendenteOptional.isPresent()) {
            atendenteRepository.deleteById(id);
            return true;
        }else  {
            return false;
        }
    }
    public Optional<AtendenteModel> findById(Long id) {
        return atendenteRepository.findById(id);
    }
}