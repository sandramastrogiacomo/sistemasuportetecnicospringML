package com.suporte.sistemasuporte.dto;

import com.suporte.sistemasuporte.model.Atendente;

public class AtendenteRespostaDTO {
    private Long id;
    private String nome;

public AtendenteRespostaDTO(Atendente atendente) {
    this.id = atendente.getId();
    this.nome = atendente.getNome();
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
}
