package com.sgpe.builder;

import com.sgpe.model.Projeto;

public class ProjetoBuilder {
    private int id;
    private String nome;
    private double orcamento = 0.0;
    private String descricao = "Sem descrição";
    
    public ProjetoBuilder setId(int id) {
        this.id = id;
        return this;
    }
    
    public ProjetoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }
    
    public ProjetoBuilder setOrcamento(double orcamento) {
        this.orcamento = orcamento;
        return this;
    }
    
    public ProjetoBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    
    public Projeto build() {
        return new Projeto(id, nome, orcamento, descricao);
    }
}
