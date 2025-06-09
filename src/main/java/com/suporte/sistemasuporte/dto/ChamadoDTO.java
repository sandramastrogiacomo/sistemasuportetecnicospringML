package com.suporte.sistemasuporte.dto;

import java.time.LocalDateTime;

public class ChamadoDTO {

    private String nomeCliente;
    private String nomeProduto;
    private String estadoChamado;
    private Long atendenteId;
    private Long balcaoAtendimentoId;
    private LocalDateTime dataHora;

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

    public Long getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Long atendenteId) {
        this.atendenteId = atendenteId;
    }

    public Long getBalcaoAtendimentoId() {
        return balcaoAtendimentoId;
    }

    public void setBalcaoAtendimentoId(Long balcaoAtendimentoId) {
        this.balcaoAtendimentoId = balcaoAtendimentoId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}


