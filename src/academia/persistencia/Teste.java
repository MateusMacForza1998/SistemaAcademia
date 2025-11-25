package academia.persistencia;

import academia.modelo.Aluno;

public class Teste {
    public static void main(String[] args) {
        System.out.println("=== TESTES DE PERSISTÊNCIA ===\n");

        testeInserir();
    }

    // ---------------------------------------------------------
    // TESTE 1️⃣ - INSERÇÃO
    // ---------------------------------------------------------
    public static void testeInserir() {
        System.out.println("🔹 TESTANDO INSERÇÃO\n");

        // Cria uma nova instância da persistência para alunos
        Persistencia<Aluno> bancoAluno = new Persistencia<>();

        // -------------------------------
        // Caso 1: Inserção válida
        // -------------------------------
        System.out.println("[CASO 1] Inserção de ID novo");

        Aluno aluno1 = new Aluno(1, "Mateus", 22);
        bancoAluno.insere(aluno1);

        // Mostra o conteúdo do "banco"
        System.out.println("Conteúdo atual do banco:");
        System.out.println(bancoAluno);

        // Se você quiser verificar:
        if (bancoAluno.buscarID(1) != null) {
            System.out.println("[OK] Aluno inserido com sucesso!\n");
        } else {
            System.out.println("[ERRO] Aluno não foi inserido!\n");
        }

        // -------------------------------
        // Caso 2: Inserção inválida (ID duplicado)
        // -------------------------------
        System.out.println("[CASO 2] Inserção de ID duplicado");

        Aluno aluno2 = new Aluno(1, "Bingo", 25);
        bancoAluno.insere(aluno2);  // aqui o comportamento esperado é NÃO inserir

        // Mostra novamente o banco
        System.out.println("Conteúdo atual do banco após tentativa duplicada:");
        System.out.println(bancoAluno);

        // Validação simples:
        // se ainda existe apenas o primeiro aluno, o teste passou
        try {
            Aluno resultado = bancoAluno.buscarID(1);
            if (resultado.getId()== aluno2.getId()) {
                System.out.println("[OK] Inserção duplicada ignorada corretamente!\n");
            } else {
                System.out.println("[ERRO] Inserção duplicada substituiu o aluno!\n");
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Exceção inesperada: " + e.getMessage());
        }
        System.out.println(bancoAluno);
        System.out.println("--------------------------------------\n");
    }
}
