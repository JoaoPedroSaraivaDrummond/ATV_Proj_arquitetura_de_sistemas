package com.sgpe.repository;

import com.sgpe.model.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjetoRepository {
    private static ProjetoRepository instance;
    private List<Projeto> projetos;
    private int nextId = 1;
    
    private ProjetoRepository() {
        projetos = new ArrayList<>();
    }
    
    public static synchronized ProjetoRepository getInstance() {
        if (instance == null) {
            instance = new ProjetoRepository();
        }
        return instance;
    }
    
    public int generateId() {
        return nextId++;
    }
    
    public void add(Projeto p) {
        projetos.add(p);
    }
    
    public List<Projeto> findAll() {
        return projetos;
    }
    
    public Optional<Projeto> findById(int id) {
        return projetos.stream().filter(p -> p.getId() == id).findFirst();
    }
    
    public void update(Projeto p) {
        // Simulação de persistência
    }
    
    public boolean delete(int id) {
        return projetos.removeIf(p -> p.getId() == id);
    }
}
