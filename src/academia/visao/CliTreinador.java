package academia.visao;

import java.util.Scanner;

import academia.modelo.Treinador;
import academia.persistencia.Banco;

public class CliTreinador {
    public static void menuTreinador(Banco banco) {

        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("========== PAINEL TREINADORES ==========");
            System.out.println("\n\n Digite uma opção para obter um acesso\n\n");
            System.out.println("0 - INSERIR TREINADOR\n1 - EXCLUIR TREINADOR\n2 - EDITAR TREINADOR\n3 - VER TREINADOR PELA ID\n4 - VER TODOS TREINADORS\n5 - VOLTAR PARA O MENU PRINCIPAL - \n\n");
            System.out.println("=========== PAINEL TREINADORES ==========");
            opcao = menu.nextInt();
            menu.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Digite a ID do treinador:");
                    int id = menu.nextInt();
                    menu.nextLine();
                    System.out.println("Digite o nome do Treinador:");
                    String nome = menu.nextLine();
                    System.out.println("Digite a idade do Treinador:");
                    int idade = menu.nextInt();
                    menu.nextLine();
                    System.out.println("Digite a CREF o Treinador:");
                    int CREF = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoTreinador().buscarID(id) != null) {
                        System.out.println("ID de Treinador já inserido!");
                        
                    }else{
                        Treinador t1 = new Treinador(id, nome, idade, CREF);
                        banco.getBancoTreinador().insere(t1);
                        System.out.println("Treinador inserido com sucesso!"); 
                    }                
                    break;
                case 1:
                    System.out.println("Digite a ID do treinador:");
                    int idExcluir = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoAluno().buscarID(idExcluir) == null) {
                        System.out.println("ID não encontrada!");
                    }else{
                    banco.getBancoTreinador().excluirID(idExcluir);
                    System.out.println("EXCLUINDO...");
                    }
                    break;
                case 2:
                    System.out.println("Digite a ID do Treinador");
                    int idbus = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoAluno().buscarID(idbus) == null) {
                        System.out.println("ID não encontrada!");
                    }else{
                        System.out.println("Digite o novo nome:"); 
                        String nomeNovo = menu.nextLine(); 
                        System.out.println(("Digite a nova idade:")); 
                        int idadeNovo = menu.nextInt(); 
                        menu.nextLine(); 
                        System.out.println("Digite o novo CREF:"); 
                        int crefNovo = menu.nextInt(); 
                        menu.nextLine(); 
                        Treinador t2 = new Treinador(idbus, nomeNovo, idadeNovo,crefNovo);
                        banco.getBancoTreinador().altera(t2); 
                        System.out.println("Treinador editado com sucesso!"); 
                        break;
                    }
                    break;
                case 3:
                    opcao = 3;
                    System.out.println("Digite a ID do Treinador");
                    int idbuscar = menu.nextInt();
                    menu.nextLine();
                    if (banco.getBancoTreinador().buscarID(idbuscar)==null) {
                        System.out.println("ID não encontrada");
                        
                    }else{
                        System.out.println(banco.getBancoTreinador().buscarID(idbuscar));
                    }
                    break;
                case 4:
                    System.out.println(banco.getBancoTreinador().toString());
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
