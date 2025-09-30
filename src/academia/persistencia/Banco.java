package academia.persistencia;

public class Banco {

    private Persistencia Aluno;
    private Persistencia Treinador;
    private Persistencia Treino;

    public Banco(Persistencia Aluno, Persistencia Treinador, Persistencia Treino){
        this.Aluno = Aluno;
        this.Treinador = Treinador;
        this.Treino = Treino;
    }

    public Persistencia getBancoAluno(){
        return this.Aluno;
    }
    public void setBancoAluno(Persistencia Aluno){
        this.Aluno = Aluno;
    }

    public Persistencia getBancoTreinador(){
        return this.Treinador;
    }

    public void setBancoTreinador(Persistencia Treinador){
        this.Treinador = Treinador;
    }
    public Persistencia getBancoTreino(){
        return this.Treino;
    }

    public void setBancoTreino(Persistencia Treino){
        this.Treino = Treino;
    }
}