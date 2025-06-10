package com.suporte.sistemasuporte.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "atendentes")
public class AtendenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nomeBalcao;

@ManyToOne
@JoinColumn(name = "balcao_id")
private BalcaoAtendimentoModel balcao;

@OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
private List<ChamadoModel> chamados;

public AtendenteModel() {

}

public AtendenteModel(Long id, String nome, String nomeBalcao) {
    this.id = id;
    this.nome = nome;
    this.nomeBalcao = nomeBalcao;

}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeBalcao() {
        return nomeBalcao;
    }

    public void setNomeBalcao(String nomeloja) {
        this.nomeBalcao = nomeBalcao;
    }

    public List<ChamadoModel> getChamados() {
        return chamados;
    }

    public void setChamados(List<ChamadoModel> chamados) {
        this.chamados = chamados;
    }
}