package academia.modelo;

public abstract class Entidade {

    public int id;

    public Entidade(int id){
        this.id = id;

    }
    public int GetId(){
        return id;
    }
    public void SetId(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "| ID: " + id;
    }

}
