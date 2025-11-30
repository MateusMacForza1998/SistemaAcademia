package academia.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ficha extends Entidade {
    private Aluno aluno;                
    private Treinador treinador;        
    private List<Exercicio> exercicios; 
    

    public Ficha(int id, Aluno aluno, Treinador treinador) {
        super(id);
        this.aluno = aluno;
        this.treinador = treinador;
        this.exercicios = new ArrayList<>();
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public List<Exercicio> getExercicios() {
        return new ArrayList<>(exercicios);
    }

    public void setExercicios(List<Exercicio> lista) {
        if (lista != null) {
            this.exercicios = new ArrayList<>(lista);
        }
    }

    
    public void adicionarExercicio(Exercicio e) {
        if (e != null && !exercicios.contains(e)) {
            exercicios.add(e);
        }
    }

    public void removerExercicio(Exercicio e) {
        exercicios.remove(e);
    }

    @Override
    public String toString() {
        return "Ficha{id=" + id +
                ", aluno=" + aluno.getNome() +
                ", treinador=" + treinador.getNome() +
                ", qtdeExercicios=" + exercicios.size() +
                "}";
    }
}
