package academia.modelo;

public class ItemTreino extends Entidade {

    private Exercicio exercicio;
    private int serie;
    private int repeticao;

    public ItemTreino(int id, Exercicio exercicio, int serie, int repeticao) {
        super(id);
        this.exercicio = exercicio;
        this.serie = serie;
        this.repeticao = repeticao;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    @Override
    public String toString() {
        return "Exercício: " + exercicio.getNomeExercicio() +
               " | Séries: " + serie +
               " | Repetições: " + repeticao;
    }
}
