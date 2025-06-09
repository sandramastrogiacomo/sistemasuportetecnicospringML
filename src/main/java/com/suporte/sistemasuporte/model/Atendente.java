package com.suporte.sistemasuporte.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "atendentes")
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nomeBalcao;

@ManyToOne
@JoinColumn(name = "balcao_id")
private BalcaoAtendimento balcao;

@OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Chamado> chamados;

public Atendente () {

}

public Atendente (Long id, String nome, String nomeBalcao) {
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

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}