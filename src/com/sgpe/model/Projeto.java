package com.sgpe.model;

public class Projeto {
    private int id;
    private String nome;
    private double orcamento;
    private String descricao;
    
    public Projeto(int id, String nome, double orcamento, String descricao) {
        this.id = id;
        this.nome = nome;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getOrcamento() { return orcamento; }
    public void setOrcamento(double orcamento) { this.orcamento = orcamento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    @Override
    public String toString() {
        return "Projeto [ID=" + id + ", Nome=" + nome + ", Orçamento=" + String.format("%.2f", orcamento) + ", Descrição=" + descricao + "]";
    }
}
