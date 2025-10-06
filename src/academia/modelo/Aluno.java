package academia.modelo;

public class Aluno extends Entidade {
    private String nome;
    private int idade;

    public Aluno(int id, String nome, int idade){
        super(id);
        this.nome = nome;
        this.idade = idade;
    }
    public String getNomeAluno(){
        return nome;
    }
    public void setNomeAluno(String nome){
        this.nome = nome;
    }
    public int getIdadeAluno(){
        return idade;
    }
    public void setIdadeAluno(int idade){
        this.idade = idade;
    }
    @Override
    public String toString() {
    return "Aluno" + super.toString() +
    " | ID: " + getId() +
    " | Nome: " + nome + 
    " | Idade: " + idade;
    }

    
}
