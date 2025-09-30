package academia.visao;

import java.util.Scanner;

public class CliTreino {

    public static void main(String[] args) throws Exception {

        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("========== PAINEL TREINOS ==========");
            System.out.println("\n\n Digite uma opção para obter um acesso\n\n");
            System.out.println("0 - INSERIR TREINO\n1 - EXCLUIR TREINO\n2 - EDITAR TREINO\n3 - VER TREINO PELA ID\n4 - VER TODOS TREINOS\n5 - VOLTAR PARA O MENU PRINCIPAL - \n\n");
            System.out.println("=========== PAINEL TREINOS ==========");
            opcao = menu.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("INSERINDO...");                    
                    break;
                case 1:
                    System.out.println("EXCLUINDO...");
                    break;
                case 2:
                    System.out.println("EDITANDO...");
                    break;
                case 3:
                    opcao = 3;
                    System.out.println("VIZUALIZANDO POR ID...");
                    break;
                case 4:
                    System.out.println("VIZUALIZANDO TODOS...");
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