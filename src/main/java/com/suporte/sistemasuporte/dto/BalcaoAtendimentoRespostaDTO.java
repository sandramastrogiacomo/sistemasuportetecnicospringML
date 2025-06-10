package com.suporte.sistemasuporte.dto;

import com.suporte.sistemasuporte.model.BalcaoAtendimentoModel;

public class BalcaoAtendimentoRespostaDTO {

        private Long id;
        private String nomeBalcao;

       public BalcaoAtendimentoRespostaDTO() {
    }
    public BalcaoAtendimentoRespostaDTO(Long id, String nomeBalcao) {
           this.id = id;
           this.nomeBalcao = nomeBalcao;
    }

    public BalcaoAtendimentoRespostaDTO(BalcaoAtendimentoModel balcao) {
           this.id = balcao.getId();
           this.nomeBalcao = balcao.getNomeBalcao();
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
