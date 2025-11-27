package academia.modelo;

public class Exercicio extends Entidade {
    private String nomeTreino;

    public Exercicio(int id, String nomeTreino){
        super(id);
        this.nomeTreino = nomeTreino;
    }
    public String getNomeExercicio(){
        return nomeTreino;
    }
    public void setNomeExercicio(String nomeTreino){
        this.nomeTreino = nomeTreino;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNomeExercicio();
    }

}