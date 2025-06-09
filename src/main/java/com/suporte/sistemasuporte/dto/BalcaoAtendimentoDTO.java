package com.suporte.sistemasuporte.dto;

import com.suporte.sistemasuporte.model.BalcaoAtendimento;

public class BalcaoAtendimentoDTO {
    private Long id;
    private String nomeBalcao;

    public BalcaoAtendimentoDTO() {

    }
    public BalcaoAtendimentoDTO (Long id, String nomeBalcao) {
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

    public void setNomeBalcao(String nomeBalcao) {
        this.nomeBalcao = nomeBalcao;
    }
}
