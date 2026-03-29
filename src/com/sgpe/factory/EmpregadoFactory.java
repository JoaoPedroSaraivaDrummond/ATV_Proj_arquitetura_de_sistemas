package com.sgpe.factory;

import com.sgpe.model.Desenvolvedor;
import com.sgpe.model.Empregado;
import com.sgpe.model.Gerente;

public class EmpregadoFactory {
    
    public Empregado criarEmpregado(String tipo, int id, String nome) {
        if (tipo == null || tipo.isEmpty()) return null;
        
        switch (tipo.toLowerCase()) {
            case "desenvolvedor":
                return new Desenvolvedor(id, nome);
            case "gerente":
                return new Gerente(id, nome);
            default:
                throw new IllegalArgumentException("Tipo de empregado desconhecido. Use 'Desenvolvedor' ou 'Gerente'.");
        }
    }
}
