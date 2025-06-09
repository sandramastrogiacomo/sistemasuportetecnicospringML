package com.suporte.sistemasuporte.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;

    private String nomeProduto;

    private String estadoChamado;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private EstadoChamadoEnum estado;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendente;

    public Chamado() {
        this.dataHora = LocalDateTime.now();
    }

    public Chamado(Long id, String nomeCliente, String nomeProduto, String estadoChamado, LocalDateTime dataHora, Atendente atendente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.estadoChamado = estadoChamado;
        this.dataHora = dataHora;
        this.atendente = atendente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getEstadoChamado() {
        return estadoChamado;
    }

    public void setEstadoChamado(String estadoChamado) {
        this.estadoChamado = estadoChamado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public EstadoChamadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoChamadoEnum estado) {
        this.estado = estado;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @ManyToOne
    @JoinColumn(name = "balcao_atendimento_id")
    private BalcaoAtendimento balcaoAtendimento;

    public BalcaoAtendimento getBalcaoAtendimento() {
        return balcaoAtendimento;
    }

    public void setBalcaoAtendimento(BalcaoAtendimento balcaoAtendimento) {
        this.balcaoAtendimento = balcaoAtendimento;
    }
}


