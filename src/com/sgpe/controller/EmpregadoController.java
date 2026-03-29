package com.sgpe.controller;

import com.sgpe.factory.EmpregadoFactory;
import com.sgpe.model.Empregado;
import com.sgpe.repository.EmpregadoRepository;

import java.util.List;
import java.util.Optional;

public class EmpregadoController {
    private EmpregadoRepository repository;
    private EmpregadoFactory factory;
    
    public EmpregadoController() {
        this.repository = EmpregadoRepository.getInstance();
        this.factory = new EmpregadoFactory();
    }
    
    public void criarEmpregado(String tipo, String nome) {
        int newId = repository.generateId();
        try {
            Empregado emp = factory.criarEmpregado(tipo, newId, nome);
            repository.add(emp);
            System.out.println("Empregado " + nome + " cadastrado com sucesso! ID: " + newId);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar empregado: " + e.getMessage());
        }
    }
    
    public void listarEmpregados() {
        List<Empregado> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum empregado cadastrado.");
        } else {
            System.out.println("\n--- Lista de Empregados ---");
            for (Empregado emp : list) {
                System.out.println(emp);
            }
        }
    }
    
    public void atualizarEmpregado(int id, String novoNome) {
        Optional<Empregado> opt = repository.findById(id);
        if (opt.isPresent()) {
            Empregado emp = opt.get();
            emp.setNome(novoNome);
            repository.update(emp);
            System.out.println("Empregado (ID: " + id + ") atualizado com sucesso!");
        } else {
            System.out.println("Empregado não encontrado com ID: " + id);
        }
    }
    
    public void removerEmpregado(int id) {
        if (repository.delete(id)) {
            System.out.println("Empregado (ID: " + id + ") removido com sucesso!");
        } else {
            System.out.println("Falha ao remover: Empregado não encontrado com ID: " + id);
        }
    }
}
