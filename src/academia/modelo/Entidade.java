package academia.modelo;

public abstract class Entidade {

    protected int id;

    public Entidade(int id){
        this.id = id;

    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "ID=" + id;
    }

}
