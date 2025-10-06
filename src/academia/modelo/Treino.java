package academia.modelo;
import java.util.ArrayList;
import java.util.List;


public class Treino extends Entidade {

    private Aluno treinoAluno;
    private Treinador treinoTreinador;
    private List<itemTreino> fichaAluno;

    public Treino(int id, Aluno treinoAluno, Treinador treinoTreinador){
        super(id);
        this.treinoAluno = treinoAluno;
        this.treinoTreinador = treinoTreinador;
        this.fichaAluno = new ArrayList<>();
    }
    public Aluno getTreinoAluno(){
        return treinoAluno;
    }
    public void setTreinoAluno(Aluno treinoAluno){
        this.treinoAluno = treinoAluno;
    }
    public Treinador getTreinoTreinador(){
        return treinoTreinador;
    }
    public void setTreinoTreinador(Treinador treinoTreinador){
        this.treinoTreinador = treinoTreinador;
    }

    public void adicionarTreino(itemTreino exercicio){
        fichaAluno.add(exercicio);
    }
    public void  removeTreino(itemTreino exercicio){
        fichaAluno.remove(exercicio);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FichaTreino ").append(super.toString())
        .append(" | Aluno: ").append(treinoAluno.getNomeAluno())
        .append(" | Treinador: ").append(treinoTreinador.getNomeTreinador())
        .append("\nItens:\n");

        for (itemTreino t : fichaAluno) {
            sb.append(" - ").append(t.toString()).append("\n");
        }

        return sb.toString();
}


    
}
