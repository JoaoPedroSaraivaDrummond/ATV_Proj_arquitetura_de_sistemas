package com.sgpe.model;

public class Desenvolvedor extends Empregado {
    public Desenvolvedor(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String getCargo() {
        return "Desenvolvedor";
    }
}
