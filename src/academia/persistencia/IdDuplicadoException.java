package academia.persistencia;

public class IdDuplicadoException extends Exception {

    public IdDuplicadoException(int id) {
        super("Erro: Já existe um registro com o ID " + id);
    }
}
