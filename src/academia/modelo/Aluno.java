package academia.modelo;

public class Aluno extends Entidade {
    private String nome;
    private int idade;

    public Aluno(int id, String nome, int idade){
        super(id);
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }


    
}
