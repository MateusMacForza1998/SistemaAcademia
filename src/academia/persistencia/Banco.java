package academia.persistencia;

import academia.modelo.Aluno;
import academia.modelo.Treinador;
import academia.modelo.Treino;

public class Banco {

    private Persistencia<Aluno> aluno;
    private Persistencia<Treinador> treinador;
    private Persistencia<Treino> treino;

    public Banco(){
        this.aluno = new Persistencia<>();
        this.treinador = new Persistencia<>();
        this.treino = new Persistencia<>();
    }

    
    public Persistencia<Aluno> getBancoAluno(){
        return this.aluno;
    }

    public Persistencia<Treinador> getBancoTreinador(){
        return this.treinador;
    }

    public Persistencia<Treino> getBancoTreino(){
        return this.treino;
    }
}