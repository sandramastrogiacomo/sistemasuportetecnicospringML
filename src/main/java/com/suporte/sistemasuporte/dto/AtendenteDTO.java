package com.suporte.sistemasuporte.dto;

public class AtendenteDTO {
    private String nome;
    private String nomeBalcao;

    public AtendenteDTO() {

    }

    public AtendenteDTO(String nome, String nomeBalcao) {
        this.nome = nome;
        this.nomeBalcao = nomeBalcao;
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

    public void setNomeLoja(String nomeBalcao) {
        this.nomeBalcao = nomeBalcao;
    }
}
