package academia.modelo;
import java.util.ArrayList;
import java.util.List;


public class FichaTreino extends Entidade {

    public Aluno treinoAluno;
    public Treinador treinoTreinador;
    public List<Treino> FichaAluno;

    public FichaTreino(int id, Aluno treinoAluno, Treinador treinoTreinador){
        super(id);
        this.treinoAluno = treinoAluno;
        this.treinoTreinador = treinoTreinador;
        this.FichaAluno = new ArrayList<>();
    }
    public Aluno GetTreinoAluno(){
        return treinoAluno;
    }
    public void SetTreinoAluno(Aluno treinoAluno){
        this.treinoAluno = treinoAluno;
    }
    public Treinador GetTreinoTreinador(){
        return treinoTreinador;
    }
    public void SetTreinoTreinoTreinadorador(Treinador treinoTreinador){
        this.treinoTreinador = treinoTreinador;
    }

    public void adicionarTreino(Treino exercicio){
        FichaAluno.add(exercicio);
    }
    public void  removeTreino(Treino exercicio){
        FichaAluno.add(exercicio);
    }
    


    
}
