package academia.modelo;

public class Aluno extends Entidade {
    private String nome;
    private int idade;

    public Aluno(int id, String nome, int idade){
        super(id);
        this.nome = nome;
        this.idade = idade;
    }
    public String GetNomeA(){
        return nome;
    }
    public void SetNomeA(String nome){
        this.nome = nome;
    }
    public int GetIdadeA(){
        return idade;
    }
    public void SetIdade(int idade){
        this.idade = idade;
    }
    @Override
    public String toString() {
        return super.toString() + " | Nome: " + nome + " | Idade: " + idade;
    }
    
}
