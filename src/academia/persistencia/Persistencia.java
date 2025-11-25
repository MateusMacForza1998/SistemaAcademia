package academia.persistencia;

import java.util.ArrayList;
import java.util.List;

import academia.modelo.Entidade;


public class Persistencia<T  extends Entidade>{
    private List<T> iDentidades;

    public Persistencia(){
    this.iDentidades = new ArrayList<>();

}

    // Métodos
    
    public void insere(T entidade){
        iDentidades.add(entidade);
        return;
    }
    public void altera(T Entidade){
        for(int i = 0; i < iDentidades.size(); i++){
            if (iDentidades.get(i).getId() == Entidade.getId()) {
                iDentidades.set(i, Entidade);
                return;
            }
        }
    }
    public void excluirID(int id){
        for(int i = 0; i < iDentidades.size(); i++){
            if (iDentidades.get(i).getId() == id) {
                iDentidades.remove(i);
                return;
            }
            
        }


    }
    public T buscarID(int id){
        for (T e : iDentidades) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entidade e : iDentidades) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
}

    
}


