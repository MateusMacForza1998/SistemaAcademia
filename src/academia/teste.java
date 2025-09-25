package academia;

import academia.modelo.Aluno;
import academia.modelo.Treinador;
import academia.modelo.FichaTreino;
import academia.modelo.Treino;
import academia.persistencia.Persistencia;
import academia.persistencia.Banco;
import academia.visao.CliAluno;
import academia.visao.CliTreinador;
 


public class teste {
    public static void main(String[] args) throws Exception {
        //crio o aluno por atributo
        Aluno a1 = new Aluno(0, "Mateus", 22);

        //crio o treinador 
        Treinador t1 = new Treinador(0, "Igor", 26, 12345);

        //crio o exercicio
        Treino f1 = new Treino("Supino", 4, 3, 4.5f);

        //crio o treino e passo o professor responsavel pelo o aluno em questao
        FichaTreino tr1 = new FichaTreino(0, a1, t1);
        System.out.println("---------------------------------------");
        System.out.println("|NOME TREINADOR: " +t1.GetNomeT()+"     |");
        System.out.println("|IDADE TREINADOR: " +t1.GetIdadeT()+"   |");
        System.out.println("|CREF TREINADOR: " +t1.GetCREF()+"      |");
        System.out.println("---------------------------------------");
        System.out.println("|NOME ALUNO: "+ a1.GetNomeA()+"         |");
        System.out.println("|IDADE ALUNO: "+a1.GetIdadeA()+"        |");
        System.out.println("---------------------------------------");

        System.out.println(f1);


        
        

    }
}
