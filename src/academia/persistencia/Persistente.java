package academia.persistencia;

import academia.modelo.Entidade;
import java.util.ArrayList;
import java.util.List;

public class Persistente<T extends Entidade> {

    private List<T> banco;

    public Persistente() {
        this.banco = new ArrayList<>();
    }


    public void inserir(T obj) throws IdDuplicadoException {
        for (T item : banco) {
            if (item.getId() == obj.getId()) {
                throw new IdDuplicadoException(obj.getId());
            }
        }
        banco.add(obj);
    }


    public void alterar(T obj) throws IdInexistenteException {
        for (int i = 0; i < banco.size(); i++) {
            if (banco.get(i).getId() == obj.getId()) {
                banco.set(i, obj);
                return;
            }
        }
        throw new IdInexistenteException(obj.getId());
    }



    public void apagar(int id) throws IdInexistenteException {
        for (int i = 0; i < banco.size(); i++) {
            if (banco.get(i).getId() == id) {
                banco.remove(i);
                return;
            }
        }
        throw new IdInexistenteException(id);
    }



    public T buscar(int id) throws IdInexistenteException {
        for (T item : banco) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new IdInexistenteException(id);
    }

    
    public List<T> listarTodos() {
        return new ArrayList<>(banco);
    }
}
