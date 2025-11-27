package academia.persistencia;

import academia.modelo.Aluno;
import org.junit.jupiter.api.*;
import java.util.List;

public class PersistenteAlunoTest {

    private Persistente<Aluno> bd;

    @BeforeEach
    public void inicializar() {
        bd = new Persistente<>();
    }

    @AfterEach
    public void finalizar() {
        bd = null;
    }

    

    @Test
    public void testInserirIdNovo() throws Exception {
        Aluno a1 = new Aluno(1, "Mateus", 22);

        Assertions.assertDoesNotThrow(() -> bd.inserir(a1));

        List<Aluno> lista = bd.listarTodos();
        Assertions.assertEquals(1, lista.size());
        Assertions.assertEquals(1, lista.get(0).getId());
    }

    @Test
    public void testInserirIdDuplicado() throws Exception {
        bd.inserir(new Aluno(1, "Mateus", 22));

        Assertions.assertThrows(
            IdDuplicadoException.class,
            () -> bd.inserir(new Aluno(1, "Outro Nome", 30))
        );
    }



    @Test
    public void testAlterarIdInexistente() {
        Aluno a1 = new Aluno(99, "Fantasma", 10);

        Assertions.assertThrows(
            IdInexistenteException.class,
            () -> bd.alterar(a1)
        );
    }

    @Test
    public void testAlterarIdExistente() throws Exception {
        bd.inserir(new Aluno(1, "Mateus", 22));

        Aluno alterado = new Aluno(1, "Mateus Alterado", 30);

        Assertions.assertDoesNotThrow(() -> bd.alterar(alterado));

        Aluno buscado = bd.buscar(1);
        Assertions.assertEquals("Mateus Alterado", buscado.getNome());
        Assertions.assertEquals(30, buscado.getIdade());
    }



    @Test
    public void testApagarIdInexistente() {
        Assertions.assertThrows(
            IdInexistenteException.class,
            () -> bd.apagar(88)
        );
    }

    @Test
    public void testApagarIdExistente() throws Exception {
        bd.inserir(new Aluno(1, "Mateus", 22));

        Assertions.assertDoesNotThrow(() -> bd.apagar(1));

        Assertions.assertEquals(0, bd.listarTodos().size());
    }



    @Test
    public void testBuscarIdInexistente() {
        Assertions.assertThrows(
            IdInexistenteException.class,
            () -> bd.buscar(99)
        );
    }

    @Test
    public void testBuscarIdExistente() throws Exception {
        bd.inserir(new Aluno(5, "Carlos", 19));

        Aluno buscado = bd.buscar(5);

        Assertions.assertNotNull(buscado);
        Assertions.assertEquals("Carlos", buscado.getNome());
        Assertions.assertEquals(19, buscado.getIdade());
    }
}
