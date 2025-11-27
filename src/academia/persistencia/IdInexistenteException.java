package academia.persistencia;

public class IdInexistenteException extends Exception {

    public IdInexistenteException(int id) {
        super("ID " + id + " não encontrado no banco de dados.");
    }
}
