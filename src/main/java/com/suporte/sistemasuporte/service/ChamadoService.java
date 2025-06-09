package com.suporte.sistemasuporte.service;

import com.suporte.sistemasuporte.dto.ChamadoDTO;
import com.suporte.sistemasuporte.dto.ChamadoRespostaDTO;
import com.suporte.sistemasuporte.model.Atendente;
import com.suporte.sistemasuporte.model.BalcaoAtendimento;
import com.suporte.sistemasuporte.model.Chamado;
import com.suporte.sistemasuporte.repository.AtendenteRepository;
import com.suporte.sistemasuporte.repository.BalcaoAtendimentoRepository;
import com.suporte.sistemasuporte.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private BalcaoAtendimentoRepository balcaoAtendimentoRepository;

    @Autowired
    private AtendenteRepository atendenteRepository;

    public ChamadoRespostaDTO criarChamado(ChamadoDTO dto) {
        Atendente atendente = atendenteRepository.findById(dto.getAtendenteId()).orElse(null);
        BalcaoAtendimento balcaoAtendimento = balcaoAtendimentoRepository.findById(dto.getBalcaoAtendimentoId()).orElse(null);

        Chamado chamado = new Chamado();
        chamado.setNomeCliente(dto.getNomeCliente());
        chamado.setNomeProduto(dto.getNomeProduto());
        chamado.setEstadoChamado(dto.getEstadoChamado());
        chamado.setDataHora(dto.getDataHora());
        chamado.setAtendente(atendente);

        Chamado salvo = chamadoRepository.save(chamado);
        return converterParaDTOResposta(salvo);
    }

        public List<ChamadoRespostaDTO> listarTodos () {
           return chamadoRepository.findAll()
                .stream()
                    .map(this::converterParaDTOResposta)
                    .collect(Collectors.toList());
        }

        public ChamadoRespostaDTO buscarChamadoPorId (Long id){
        return  chamadoRepository.findById(id)
                .map(this::converterParaDTOResposta)
                .orElse(null);
        }

        public ChamadoRespostaDTO atualizar(Long id,  ChamadoDTO dto) {
        Optional<Chamado> chamadoOptional = chamadoRepository.findById(id);
        if (chamadoOptional.isPresent()) {
            Chamado chamado = chamadoOptional.get();

            Atendente atendente = atendenteRepository.findById(dto.getAtendenteId()).orElse(null);
            BalcaoAtendimento balcaoAtendimento = balcaoAtendimentoRepository.findById(dto.getBalcaoAtendimentoId()).orElse(null);

            chamado.setNomeCliente(dto.getNomeCliente());
            chamado.setNomeProduto(dto.getNomeProduto());
            chamado.setEstadoChamado(dto.getEstadoChamado());
            chamado.setDataHora(dto.getDataHora());
            chamado.setAtendente(atendente);

            Chamado atualizado = chamadoRepository.save(chamado);
            return converterParaDTOResposta(atualizado);
        }

        return null;
        }

        public void deletar (Long id) {
        chamadoRepository.deleteById(id);
        }

        public List<Chamado> listarChamadosPorEstadoChamado(String estadoChamado) {
        return chamadoRepository.findByEstadoChamado(estadoChamado);

        }

        public List<Chamado> listarChamadoPorAtendente(Long atendenteId) {
        return chamadoRepository.findByAtendenteId(atendenteId);
        }

        private ChamadoRespostaDTO converterParaDTOResposta(Chamado chamado) {
        return  new ChamadoRespostaDTO(
                chamado.getId(),
                chamado.getNomeCliente(),
                chamado.getNomeProduto(),
                chamado.getEstadoChamado(),
                chamado.getAtendente() != null ? chamado.getAtendente().getNome() : null,
                chamado.getDataHora());
        }

}




