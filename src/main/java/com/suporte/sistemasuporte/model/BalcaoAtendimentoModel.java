package com.suporte.sistemasuporte.model;

import com.suporte.sistemasuporte.dto.BalcaoAtendimentoRespostaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BalcaoAtendimentoModel extends BalcaoAtendimentoRespostaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeBalcao;

    @OneToMany(mappedBy = "balcao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtendenteModel> atendentes;

    public BalcaoAtendimentoModel() {
    }
    public BalcaoAtendimentoModel(Long id, String nomeBalcao) {
        this.id = id;
        this.nomeBalcao = nomeBalcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeBalcao() {
        return nomeBalcao;
    }

    public void setNomeLoja(String nomeBalcao) {
        this.nomeBalcao = nomeBalcao;
    }

    public List<AtendenteModel> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<AtendenteModel> atendentes) {
        this.atendentes = atendentes;
    }
}