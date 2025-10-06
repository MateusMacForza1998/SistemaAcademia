package academia.visao;

import java.util.Scanner;

import academia.modelo.Aluno;
import academia.persistencia.Banco;

public class CliAluno {
    public static void menuAluno(Banco banco){

        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("========== PAINEL ALUNOS ==========");
            System.out.println("\n\n Digite uma opção para obter um acesso\n\n");
            System.out.println("0 - INSERIR ALUNO\n1 - EXCLUIR ALUNO\n2 - EDITAR ALUNO\n3 - VER ALUNO PELA ID\n4 - VER TODOS ALUNOS\n5 - VOLTAR PARA O MENU PRINCIPAL - \n\n");
            System.out.println("=========== PAINEL ALUNOS ==========");
            opcao = menu.nextInt();
            menu.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Digite o ID do aluno:");
                    int id = menu.nextInt();
                    menu.nextLine();
                    
                    if (banco.getBancoAluno().buscarID(id) != null) {
                        System.out.println("Já Existe aluno com essa ID!");
                    }else{
                        System.out.println("Digite o nome do aluno:");
                        String nome = menu.nextLine();
                        System.out.println("Digite a idade do aluno:");
                        int idade = menu.nextInt();
                        menu.nextLine();
                        Aluno a = new Aluno(id, nome, idade);
                        banco.getBancoAluno().insere(a);
                        System.out.println("ALUNO INSERIDO COM SUCESSO"); 
                    }         
                    break;
                case 1:
                    System.out.println("Digite a ID do Aluno:");
                    int idExcluir = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoAluno().buscarID(idExcluir) == null) {
                        System.out.println(("ID não encontrada!"));
                    }else{
                        banco.getBancoAluno().excluirID(idExcluir);
                        System.out.println("Excluido com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Digite a ID do Aluno:");
                    int idEditar = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoAluno().buscarID(idEditar) == null) {
                        System.out.println("ID não encontrada!");
                    }else{
                        System.out.println("Digite o novo nome");
                        String nomeNovo = menu.nextLine();
                        System.out.println("Digite a nova idade:");
                        int idadeNovo = menu.nextInt();
                        menu.nextLine();
                        Aluno a1 = new Aluno(idEditar, nomeNovo, idadeNovo);
                        banco.getBancoAluno().altera(a1);
                        System.out.println("EDITANDO...");
                    }
                    
                    break;
                case 3:
                    System.out.println("VIZUALIZANDO POR ID...");
                    System.out.println("Digite a ID para vizualiza:");
                    int bid = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoAluno().buscarID(bid)==null) {
                        System.out.println("ID não encontrada");
                    }else{
                        System.out.println(banco.getBancoAluno().buscarID(bid));
                    }
                    break;
                case 4:
                    System.out.println(banco.getBancoAluno().toString());                  
                    System.out.println("VIZUALIZANDO TODOS");
                    break;
                case 5:
                    opcao = 5;
                    System.out.println("VOLTANDO...");
                    break;
            
                default:
                    System.out.println("Digite uma opção valida");
                    break;
            }
            
        }
    }
}
