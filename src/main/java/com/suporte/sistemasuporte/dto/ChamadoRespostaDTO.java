package com.suporte.sistemasuporte.dto;


import com.suporte.sistemasuporte.model.ChamadoModel;

import java.time.LocalDateTime;

public class ChamadoRespostaDTO {

    private Long id;
    private String nomeCliente;
    private String nomeProduto;
    private String estadoChamado;
    private String nomeAtendente;
    private String nomeBalcao;
    private LocalDateTime dataHora;

    public ChamadoRespostaDTO() {
    }

    public ChamadoRespostaDTO(Long id, String nomeCliente, String nomeProduto, String estadoChamado, String nomeAtendente, LocalDateTime dataHora) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.estadoChamado = estadoChamado;
        this.nomeAtendente = nomeAtendente;
        this.nomeBalcao = nomeBalcao;
        this.dataHora = dataHora;
    }

    public ChamadoRespostaDTO(ChamadoModel chamado) {
        this.id = chamado.getId();
        this.nomeCliente = chamado.getNomeCliente();
        this.nomeProduto = chamado.getNomeProduto();
        this.estadoChamado = chamado.getEstadoChamado();
        this.dataHora = chamado.getDataHora();

        if(chamado.getAtendente() != null) {
            this.nomeAtendente = chamado.getAtendente().getNome();
        }
        if (chamado.getBalcaoAtendimento() != null) {
            this.nomeBalcao = chamado.getBalcaoAtendimento().getNomeBalcao();
        }
    }

    public ChamadoRespostaDTO(ChamadoRespostaDTO chamadoRespostaDTO) {
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

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getNomeBalcao() {
        return nomeBalcao;
    }

    public void setNomeBalcao(String nomeBalcao) {
        this.nomeBalcao = nomeBalcao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
