package academia.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ficha extends Entidade {
    private Aluno aluno;
    private Treinador treinador;

    private List<ItemTreino> itens;

    public Ficha(int id, Aluno aluno, Treinador treinador) {
        super(id);
        this.aluno = aluno;
        this.treinador = treinador;
        this.itens = new ArrayList<>();
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

    public List<ItemTreino> getItens() {
        return new ArrayList<>(itens);
    }

    public void setItens(List<ItemTreino> itens) {
        if (itens != null) {
            this.itens = new ArrayList<>(itens);
        }
    }

    public void adicionarItem(ItemTreino item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public void removerItem(ItemTreino item) {
        itens.remove(item);
    }

    @Override
    public String toString() {
        return "Ficha{id=" + id +
               ", aluno=" + aluno.getNome() +
               ", treinador=" + treinador.getNome() +
               ", itens=" + itens.size() +
               "}";
    }
}
