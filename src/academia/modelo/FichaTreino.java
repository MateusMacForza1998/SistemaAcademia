package academia.modelo;
import java.util.ArrayList;
import java.util.List;


public class FichaTreino extends Entidade {

    private Aluno treinoAluno;
    private Treinador treinoTreinador;
    private List<Treino> fichaAluno;

    public FichaTreino(int id, Aluno treinoAluno, Treinador treinoTreinador){
        super(id);
        this.treinoAluno = treinoAluno;
        this.treinoTreinador = treinoTreinador;
        this.fichaAluno = new ArrayList<>();
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
    public void SetTreinoTreinadorador(Treinador treinoTreinador){
        this.treinoTreinador = treinoTreinador;
    }

    public void adicionarTreino(Treino exercicio){
        fichaAluno.add(exercicio);
    }
    public void  removeTreino(Treino exercicio){
        fichaAluno.remove(exercicio);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FichaTreino ").append(super.toString())
        .append(" | Aluno: ").append(treinoAluno.getNomeAluno())
        .append(" | Treinador: ").append(treinoTreinador.getNomeTreinador())
        .append("\nItens:\n");

        for (Treino t : fichaAluno) {
            sb.append(" - ").append(t.toString()).append("\n");
        }

        return sb.toString();
}


    
}
