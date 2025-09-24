package academia;

import academia.modelo.Aluno;
import academia.modelo.Treinador;


public class teste {
    public static void main(String[] args) throws Exception {
        
        Aluno a = new Aluno(0, "Mateus", 22);
        Treinador t = new Treinador(0, "Paulo", 40, 550);

        System.out.println("___________________________");
        
        System.out.println("|ID: " +a.GetId());
        System.out.println("|Aluno: " +a.GetNomeA());
        System.out.println("|Idade: " +a.GetIdadeA());


        System.out.println("___________________________");
        System.out.println("|ID: " +t.GetId());
        System.out.println("|Professor: " +t.GetNomeT());
        System.out.println("|Idade: " +t.GetIdadeT());
        System.out.println("|CREF: " +t.GetNomeT());
        System.out.println("___________________________");


    }
}
