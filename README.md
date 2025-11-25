# SistemaAcademia

#**Participantes**

MATEUS SILVA FERREIRA BATISTA
ANGELO ESTANISLAU DE PAULA AVELAR
EMANUEL FELÍCIO DE ALMEIDA
IGOR ALVES FIGUEIREDO
ANDRÉ LOURENÇONI FREITAS

## 1. Introdução

O **ACADEMIA GRUPO VIDA** é um programa desenvolvido em **Java** com base nos princípios da **Programação Modular** e **Orientação a Objetos**.  

O sistema foi elaborado como parte do **Trabalho Prático 1 de Programação Modular**, atendendo a todos os requisitos definidos no enunciado da disciplina.

---

## 2. Estrutura do Projeto

O código-fonte está organizado em um pacote principal (`academia`) e três subpacotes principais, conforme solicitado:

```
academia
├── modelo
│   ├── Entidade.java
│   ├── Aluno.java
│   ├── Treinador.java
│   ├── Treino.java
│   └── itemTreino.java
│
├── persistencia
│   ├── Persistencia.java
│   └── Banco.java
│
└── visao
    ├── Programa.java
    ├── CliAluno.java
    ├── CliTreinador.java
    └── CliTreino.java
```
---

## 3. Descrição dos Pacotes

### 3.1 Pacote `modelo`
Contém todas as classes que representam as **entidades** do sistema.

- **Entidade (abstrata)**: classe base com o atributo `id` e métodos getters, setters e `toString()`.  
- **Aluno**: representa um aluno da academia, com atributos como `nome` e `idade`.  
- **Treinador**: representa o profissional responsável pelos treinos.  
- **Treino**: é a **classe de transação** do sistema, responsável por associar um aluno e um treinador, além de conter uma **composição** com a classe `itemTreino`.  
- **itemTreino**: classe intermediária que representa os exercícios (itens) de um treino, contendo informações como tipo de exercício e repetições.

O relacionamento entre `Treino` e `itemTreino` é de **composição (1..*)**, e há associações com as entidades `Aluno` e `Treinador`.

---

### 3.2 Pacote `persistencia`
Gerencia o armazenamento temporário das entidades em memória.

- **Persistencia**: possui uma lista genérica de objetos `Entidade`, com métodos para **inserir**, **alterar**, **excluir**, **buscar** por ID e **listar todos**.
- **Banco**: agrega uma instância de `Persistencia` para cada entidade principal (`Aluno`, `Treinador` e `Treino`), simulando um **banco de dados em memória**.

---

### 3.3 Pacote `visao`
Responsável pela interface em **linha de comando (CLI)**.

- **Programa**: classe principal com o método `main`, que inicializa o sistema e apresenta o menu principal.  
- **CliAluno**, **CliTreinador** e **CliTreino**: menus específicos para manipulação de cada entidade (inserir, alterar, excluir, visualizar e listar).

O programa segue a estrutura modular e permite navegar entre menus para gerenciar os dados.

---

### 4 Execução
Após a compilação, execute o programa principal com:

```bash
java -cp bin academia.visao.Programa
```



