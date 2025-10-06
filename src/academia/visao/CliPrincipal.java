package academia.visao;

import java.util.Scanner;

import academia.persistencia.Banco;
import academia.modelo.Treino;

public class CliPrincipal {


    public static void main(String[] args) throws Exception {
        Banco bd = new Banco();

        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("========== ACADEMIA GRUPO VIDA ==========");
            System.out.println("\n\n Digite uma opção para obter um acesso\n\n");
            System.out.println("0 - Painel do Aluno\n1 - Painel do Treinador\n2 - Painel do Treino\n3 - Sair do menu\n\n");
            System.out.println("=========== ACADEMIA GRUPO VIDA ==========");
            opcao = menu.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Entrou em aluno"); 
                    CliAluno.menuAluno(bd);
                    break;
                case 1:
                    System.out.println("Entrou em Treinador");
                    CliTreinador.menuTreinador(bd);
                    break;
                case 2:
                    System.out.println("Entrou em Treino");
                    CliTreino.menuTreino(bd);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opção valida");
                    break;
            }
            
        }
        menu.close();
    }
    
}