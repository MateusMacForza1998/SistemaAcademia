package academia.modelo;

public class Treinador extends Entidade{

    private String nome;
    private int idade;
    private int CREF;

    public Treinador(int id, String nome, int idade, int CREF) {
        super(id);
        this.nome = nome;
        this.idade = idade;
        this.CREF = CREF;
    }
    public String getNomeTreinador(){
        return nome;
    }
    public void setNomeTreinador(String nome){
        this.nome = nome;
    }
    public int getIdadeTreinador(){
        return idade;
    }
    public void setIdadeTreinador(int idade){
        this.idade = idade;
    }
    public int getCREF(){
        return CREF;
    }
    public void setCREF(int CREF){
        this.CREF = CREF;
    }

    @Override
    public String toString(){
        return "Treinador" + super.toString() +
        " | ID: " + getId() +
        " | Nome: " + nome + 
        " | Idade: " + idade+
        " | CREF: "+ CREF;
    }
    
}
