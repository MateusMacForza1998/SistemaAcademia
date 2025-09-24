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
    public String GetNomeT(){
        return nome;
    }
    public void SetNomeT(String nome){
        this.nome = nome;
    }
    public int GetIdadeT(){
        return idade;
    }
    public void SetIdadeT(int idade){
        this.idade = idade;
    }
    public int GetCREF(){
        return CREF;
    }
    public void SetCREF(int CREF){
        this.CREF = CREF;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getCREF() {
        return CREF;
    }
    public void setCREF(int cREF) {
        CREF = cREF;
    }
    @Override
    public String toString(){
        return super.toString() + "| Nome: " + nome + " | Idade: "+ idade+ "| CREF: " + CREF;
    }
    
}
