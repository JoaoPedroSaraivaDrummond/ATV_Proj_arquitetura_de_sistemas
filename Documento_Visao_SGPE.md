# Documento de Visão: Sistema de Gerenciamento de Projetos e Empregados (SGPE)

**Público-Alvo:** Avaliação Acadêmica (Professor)
**Escopo:** Aplicação Java Console (sem interface gráfica)

## 1. Propósito do Sistema
O **Sistema de Gerenciamento de Projetos e Empregados (SGPE)** tem como finalidade centralizar o cadastro e a alocação de profissionais em diferentes projetos corporativos. Ele serve como uma ferramenta de backoffice para organizar equipes, definir orçamentos de projetos e gerenciar as funções dos empregados em uma empresa. A principal motivação do sistema foi criar um ambiente simples e robusto que aplicasse os conceitos de engenharia de software e padrões de projeto essenciais.

## 2. Principais Funcionalidades
Para atender aos requisitos descritos (Opção de Dupla: 2 cadastros), o sistema implementa duas áreas fundamentais de CRUD (Create, Read, Update, Delete):
- **Gerenciamento de Empregados:** Permite a admissão de novos empregados, consulta de dados, alteração de informações como nome e cargo, e por fim a demissão (remoção) do sistema.
- **Gerenciamento de Projetos:** Possibilita criar novos projetos (com detalhes como nome, orçamento inicial, etc), ler os detalhes, modificar escopos/orçamentos e cancelar/apagar projetos do portfólio.

## 3. Principais Usuários
Dentro do escopo desenhado, o sistema destina-se primariamente a dois tipos de usuários (atores):
- **Gerentes de Recursos Humanos (RH):** Que utilizam a funcionalidade de Empregados para manter o inventário de pessoal sempre atualizado.
- **Gerentes de Projetos Institucionais ou PMO:** Que precisam catalogar e acompanhar os projetos ativos na corporação.
- **Administradores do Sistema:** Responsáveis por eventuais manutenções dos cadastros base.

---

## 4. Arquitetura e Padrões de Projeto (GoF e GRASP)

O sistema foi estruturado seguindo as boas práticas de orientação a objetos, dividindo as responsabilidades em camadas lógicas puras no Java (`model`, `controller`, `repository`, `builder`, `factory` e `ui`). Para cada um dos dois cadastros, foram empregados pelo menos 2 padrões GoF e 2 padrões GRASP.

### Cadastro 1: Empregado
**Padrões GRASP Utilizados:**
1. **Controller:** A classe `EmpregadoController` atua como o ponto de entrada das requisições geradas pelo menu textual do terminal. Ela delega o trabalho pesado de manipulação da lista para o repositório, mantendo baixo acoplamento com a interface do usuário.
2. **Creator:** A responsabilidade de **criar instâncias** não fica espalhada pelo sistema vazio, mas foi delegada de forma coesa a quem tem as informações necessárias, auxiliando a factory em estruturar as instâncias de `Empregado` a depender de seu cargo.

**Padrões GoF Utilizados:**
1. **Factory Method:** Implementado através da classe `EmpregadoFactory`. Sabendo que uma empresa pode admitir diferentes tipos de Empregados (Desenvolvedores, Gerentes), a criação direta via `new Empregado()` foi substituída por um método de fábrica que retorna o subtipo correto, facilitando aberturas futuras.
2. **Singleton:** A classe `EmpregadoRepository` armazena a lista de empregados simulando um banco de dados em memória. Para evitar inconsistências de múltiplas abstrações de armazenamento rodando ao mesmo tempo, a classe garante que exista apenas uma única instância dessa lista em toda a aplicação.

### Cadastro 2: Projeto
**Padrões GRASP Utilizados:**
1. **Controller:** O `ProjetoController` foi criado para interceptar comandos relacionados ao domínio e coordená-los sem conter nem a regra de negócio central de persistência nem detalhes de interface.
2. **Information Expert:** O `ProjetoRepository` é estabelecido como o Especialista da Informação. Uma vez que ele contém a coleção dos Projetos, é a classe de competência suprema em realizar a busca por ID, atualizar e deletar seus itens.

**Padrões GoF Utilizados:**
1. **Builder:** Implementado através do `ProjetoBuilder`. Um Projeto pode ser complexo (ter nome, orçamento, data de início, descrição). Ao invés de construtores enormes (Telescoping Constructor), o Builder permite a criação guiada e passo-a-passo melhorando a legibilidade.
2. **Singleton:** Assim como no cadastro de Empregados, o `ProjetoRepository` impõe que a base histórica de projetos compartilhada pela aplicação inteira seja referenciada a partir de uma instância única durante todo o ciclo de vida da execução.

---
**Nota:** A aplicação foca inteiramente no back-end funcional usando console para entrada e saída de dados, validando os conceitos de encapsulamento, herança, polimorfismo e design patterns apresentados na disciplina.
