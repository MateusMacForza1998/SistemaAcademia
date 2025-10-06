package academia.visao;

import java.util.Scanner;
import academia.modelo.itemTreino;
import academia.modelo.Treino;
import academia.persistencia.Banco;

public class CliTreino {

    public static void menuTreino(Banco banco) {

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
                    System.out.println("Digite a ID do exercicio!");
                    int id = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoTreino().buscarID(id) != null) {
                        System.out.println("Essa id ja tem um exercicio!");
                    }else{
                        System.out.println("Digite o Exercicio:");
                        String exercicio = menu.nextLine();
                        System.out.println("Digite quantas series tem:"); 
                        int serie = menu.nextInt();
                        menu.nextLine();
                        System.out.println("Digite quantas repetições tem:");
                        int repeticao = menu.nextInt();
                        menu.nextLine();
                        itemTreino treino = new itemTreino(id,exercicio, serie, repeticao);
                        banco.getBancoTreino().insere(treino);
                        System.out.println("Treino inserido com sucesso!"); 
                    }
                                     
                    break;
                    
                case 1:
                    System.out.println("Digite a ID do exercicio!");
                    int idExcluir = menu.nextInt();
                    menu.nextLine();
                    banco.getBancoTreino().excluirID(idExcluir);
                    System.out.println("EXCLUINDO TREINO");
                    break; 
                case 2:
                    System.out.println("Digite a ID do treino");
                    int idEditar = menu.nextInt();
                    menu.nextLine();
                    System.out.println("Novo exercício:");
                    String exercicioNovo = menu.nextLine();
                    System.out.println("Nova quantidade de séries:");
                    int serieNova = menu.nextInt();
                    menu.nextLine();
                    System.out.println("Nova quantidade de repetições:");
                    int repeticaoNova = menu.nextInt();
                    menu.nextLine();
                    itemTreino treinoEditado = new itemTreino(idEditar,exercicioNovo, serieNova, repeticaoNova);
                    banco.getBancoTreino().altera(treinoEditado);
                    System.out.println("Treino editado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite a ID que deseja busacar:");
                    int idbuscar = menu.nextInt();
                    menu.nextLine(); 
                    System.out.println(banco.getBancoTreino().buscarID(idbuscar));
                    System.out.println("VIZUALIZANDO POR ID...");
                    break;
                case 4:
                    System.out.println("=== Lista de Treinos ===");
                    System.out.println(banco.getBancoAluno());
                    System.out.println(banco.getBancoTreinador());
                    System.out.println(banco.getBancoTreino().toString());
                    System.out.println("=== Lista de Ficha ===");

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