package com.suporte.sistemasuporte.service;

import com.suporte.sistemasuporte.dto.BalcaoAtendimentoDTO;
import com.suporte.sistemasuporte.dto.BalcaoAtendimentoRespostaDTO;
import com.suporte.sistemasuporte.model.BalcaoAtendimentoModel;
import com.suporte.sistemasuporte.repository.BalcaoAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalcaoAtendimentoService {

    @Autowired
    private BalcaoAtendimentoRepository balcaoAtendimentoRepository;

    public BalcaoAtendimentoRespostaDTO criar(BalcaoAtendimentoDTO dto) {
        BalcaoAtendimentoModel balcao = new BalcaoAtendimentoModel();
        balcao.setId(dto.getId());
        balcao.setNomeBalcao(dto.getNomeBalcao());
        return new BalcaoAtendimentoRespostaDTO(balcaoAtendimentoRepository.save(balcao));

    }

    public List<BalcaoAtendimentoRespostaDTO> listarTodos() {
        return balcaoAtendimentoRepository.findAll().stream()
                .map(BalcaoAtendimentoRespostaDTO::new)
                .collect(Collectors.toList());
    }

    public BalcaoAtendimentoRespostaDTO buscarPorId(Long id) {
        BalcaoAtendimentoModel balcao = balcaoAtendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Balcão não encontrado!"));
       return new BalcaoAtendimentoRespostaDTO(balcao);
    }
    public BalcaoAtendimentoRespostaDTO atualizar(Long id, BalcaoAtendimentoDTO dto) {
        BalcaoAtendimentoModel balcao = balcaoAtendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Balcão não encontrado!"));
        balcao.setNomeBalcao(dto.getNomeBalcao());
        return new BalcaoAtendimentoRespostaDTO(balcaoAtendimentoRepository.save(balcao));
    }
    public void deletar(Long id) {
        if (balcaoAtendimentoRepository.existsById(id)) {
        }
        throw new RuntimeException("Balcão não encontrado!");
    }
}