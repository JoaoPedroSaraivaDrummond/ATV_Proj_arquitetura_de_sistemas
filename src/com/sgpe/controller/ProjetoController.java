package com.sgpe.controller;

import com.sgpe.builder.ProjetoBuilder;
import com.sgpe.model.Projeto;
import com.sgpe.repository.ProjetoRepository;

import java.util.List;
import java.util.Optional;

public class ProjetoController {
    private ProjetoRepository repository;
    
    public ProjetoController() {
        this.repository = ProjetoRepository.getInstance();
    }
    
    public void criarProjeto(String nome, double orcamento, String descricao) {
        int newId = repository.generateId();
        
        // Padrão Builder em ação
        Projeto projeto = new ProjetoBuilder()
                .setId(newId)
                .setNome(nome)
                .setOrcamento(orcamento)
                .setDescricao(descricao)
                .build();
                
        repository.add(projeto);
        System.out.println("Projeto '" + nome + "' cadastrado com sucesso! ID: " + newId);
    }
    
    public void listarProjetos() {
        List<Projeto> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
        } else {
            System.out.println("\n--- Lista de Projetos ---");
            for (Projeto p : list) {
                System.out.println(p);
            }
        }
    }
    
    public void atualizarProjeto(int id, String novoNome, double novoOrcamento, String novaDesc) {
        Optional<Projeto> opt = repository.findById(id);
        if (opt.isPresent()) {
            Projeto p = opt.get();
            if (novoNome != null && !novoNome.trim().isEmpty()) p.setNome(novoNome);
            if (novoOrcamento >= 0) p.setOrcamento(novoOrcamento);
            if (novaDesc != null && !novaDesc.trim().isEmpty()) p.setDescricao(novaDesc);
            
            repository.update(p);
            System.out.println("Projeto (ID: " + id + ") atualizado com sucesso!");
        } else {
            System.out.println("Projeto não encontrado com ID: " + id);
        }
    }
    
    public void removerProjeto(int id) {
        if (repository.delete(id)) {
            System.out.println("Projeto (ID: " + id + ") removido com sucesso!");
        } else {
            System.out.println("Falha ao remover: Projeto não encontrado com ID: " + id);
        }
    }
}
