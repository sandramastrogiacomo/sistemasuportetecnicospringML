package com.suporte.sistemasuporte.service;

import com.suporte.sistemasuporte.dto.AtendenteDTO;
import com.suporte.sistemasuporte.model.Atendente;
import com.suporte.sistemasuporte.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Atendente create(AtendenteDTO atendenteDTO) {
    Atendente atendente = new Atendente();
    atendente.setNome(atendenteDTO.getNome());
    return atendenteRepository.save(atendente);
    }

    public List<Atendente> findAll() {
        return atendenteRepository.findAll();
    }
    public boolean delete(Long id) {
        Optional<Atendente> atendenteOptional = atendenteRepository.findById(id);
        if (atendenteOptional.isPresent()) {
            atendenteRepository.deleteById(id);
            return true;
        }else  {
            return false;
        }
    }
    Optional<Atendente> findById(Long id) {
        return atendenteRepository.findById(id);
    }
}