package academia.persistencia;

public class Banco {

    private Persistencia aluno;
    private Persistencia treinador;
    private Persistencia treino;

    public Banco(){
        this.aluno = new Persistencia();
        this.treinador = new Persistencia();
        this.treino = new Persistencia();
    }

    
    public Persistencia getBancoAluno(){
        return this.aluno;
    }

    public Persistencia getBancoTreinador(){
        return this.treinador;
    }

    public Persistencia getBancoTreino(){
        return this.treino;
    }
}