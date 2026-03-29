package com.sgpe.model;

public class Gerente extends Empregado {
    public Gerente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String getCargo() {
        return "Gerente";
    }
}
