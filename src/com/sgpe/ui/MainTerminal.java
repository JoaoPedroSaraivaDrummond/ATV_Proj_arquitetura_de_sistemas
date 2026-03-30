package com.sgpe.ui;

import com.sgpe.controller.EmpregadoController;
import com.sgpe.controller.ProjetoController;

import java.util.Scanner;

public class MainTerminal {
    private static EmpregadoController empController = new EmpregadoController();
    private static ProjetoController projController = new ProjetoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        do {
            System.out.println("\n===========================================================");
            System.out.println("      Sistema de Gerenciamento de Projetos e Empregados");
            System.out.println("=============================================================");
            System.out.println("1. Gerenciar Empregados");
            System.out.println("2. Gerenciar Projetos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch(opcao) {
                case 1:
                    menuEmpregados();
                    break;
                case 2:
                    menuProjetos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuEmpregados() {
        int op = -1;
        do {
            System.out.println("\n--- Cadastro de Empregados ---");
            System.out.println("1. Cadastrar Empregado");
            System.out.println("2. Listar Empregados");
            System.out.println("3. Atualizar Empregado");
            System.out.println("4. Remover Empregado");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            try {
                op = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                op = -1;
            }

            switch(op) {
                case 1:
                    System.out.print("Tipo (Desenvolvedor ou Gerente): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    empController.criarEmpregado(tipo, nome);
                    break;
                case 2:
                    empController.listarEmpregados();
                    break;
                case 3:
                    System.out.print("ID do empregado para atualizar: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        empController.atualizarEmpregado(id, novoNome);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                case 4:
                    System.out.print("ID do empregado para remover: ");
                    try {
                        int idRem = Integer.parseInt(scanner.nextLine());
                        empController.removerEmpregado(idRem);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                case 0:
                    break;
                default:
                    if (op != -1) System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void menuProjetos() {
        int op = -1;
        do {
            System.out.println("\n--- Cadastro de Projetos ---");
            System.out.println("1. Cadastrar Projeto");
            System.out.println("2. Listar Projetos");
            System.out.println("3. Atualizar Projeto");
            System.out.println("4. Remover Projeto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            try {
                op = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                op = -1;
            }

            switch(op) {
                case 1:
                    System.out.print("Nome do Projeto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Orçamento: ");
                    double orcamento;
                    try {
                        orcamento = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Orçamento inválido! Cadastrando com 0.0");
                        orcamento = 0.0;
                    }
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    projController.criarProjeto(nome, orcamento, desc);
                    break;
                case 2:
                    projController.listarProjetos();
                    break;
                case 3:
                    System.out.print("ID do projeto para atualizar: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo Nome (deixe vazio para não alterar): ");
                        String nNome = scanner.nextLine();
                        System.out.print("Novo Orçamento (-1 para não alterar): ");
                        String orcStr = scanner.nextLine();
                        double nOrcamento = -1;
                        if (!orcStr.trim().isEmpty()) {
                             try { nOrcamento = Double.parseDouble(orcStr); } catch (Exception e){}
                        }
                        System.out.print("Nova Descrição (deixe vazio para não alterar): ");
                        String nDesc = scanner.nextLine();
                        projController.atualizarProjeto(id, nNome, nOrcamento, nDesc);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                case 4:
                    System.out.print("ID do projeto para remover: ");
                    try {
                        int idRem = Integer.parseInt(scanner.nextLine());
                        projController.removerProjeto(idRem);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                case 0:
                    break;
                default:
                    if(op != -1) System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }
}
