package academia.visao;

import java.util.Scanner;

public class CliPrincipal {
    
    public static void main(String[] args) throws Exception {

        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("========== ACADEMIA GRUPO VIDA ==========");
            System.out.println("\n\n Digite uma opção para obter um acesso\n\n");
            System.out.println("0 - Painel do Aluno\n1 - Painel do Treino\n2 - Painel do Treino\n\n");
            System.out.println("=========== ACADEMIA GRUPO VIDA ==========");
            opcao = menu.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Entrou em aluno");                    
                    break;
                case 1:
                    System.out.println("Entrou em Treino");
                    break;
                case 2:
                    System.out.println("Entrou em Treinador");
                    break;
                case 3:
                    opcao = 3;
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Digite uma opção valida");
                    break;
            }
            
        }
    }
    
}