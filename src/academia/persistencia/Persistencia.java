package academia.persistencia;


import java.util.ArrayList;
import java.util.List;

import academia.modelo.Entidade;


public class Persistencia{
    private List<Entidade> iDentidades;

    public Persistencia(){
    this.iDentidades = new ArrayList<>();

}

    // Métodos

    public void insere(Entidade e){
        iDentidades.add(e);
        return;
    }
    public void altera(Entidade e){
        for(int i = 0; i < iDentidades.size(); i++){
            if (iDentidades.get(i).getId() == e.getId()) {
                iDentidades.set(i, e);
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
    public Entidade buscarID(int id){
        for (Entidade e : iDentidades) {
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


