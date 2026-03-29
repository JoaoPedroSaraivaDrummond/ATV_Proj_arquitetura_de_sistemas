package com.sgpe.repository;

import com.sgpe.model.Empregado;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpregadoRepository {
    private static EmpregadoRepository instance;
    private List<Empregado> empregados;
    private int nextId = 1;
    
    private EmpregadoRepository() {
        this.empregados = new ArrayList<>();
    }
    
    public static synchronized EmpregadoRepository getInstance() {
        if (instance == null) {
            instance = new EmpregadoRepository();
        }
        return instance;
    }
    
    public int generateId() {
        return nextId++;
    }
    
    public void add(Empregado emp) {
        empregados.add(emp);
    }
    
    public List<Empregado> findAll() {
        return empregados;
    }
    
    public Optional<Empregado> findById(int id) {
        return empregados.stream().filter(e -> e.getId() == id).findFirst();
    }
    
    public void update(Empregado emp) {
        // Num banco de dados real isso faria o update. Em memória o objeto já está com a referência atualizada.
    }
    
    public boolean delete(int id) {
        return empregados.removeIf(e -> e.getId() == id);
    }
}
