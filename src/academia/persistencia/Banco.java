package academia.persistencia;

import academia.modelo.Aluno;
import academia.modelo.Treinador;
import academia.modelo.Ficha;
import academia.modelo.Exercicio;
import academia.modelo.ItemTreino;

public class Banco {

    private Persistente<Aluno> bdAlunos;
    private Persistente<Treinador> bdTreinadores;
    private Persistente<Ficha> bdFichas;
    private Persistente<Exercicio> bdExercicios;
    private Persistente<ItemTreino> bdItensTreino;

    public Banco() {
        this.bdAlunos = new Persistente<>();
        this.bdTreinadores = new Persistente<>();
        this.bdFichas = new Persistente<>();
        this.bdExercicios = new Persistente<>();
        this.bdItensTreino = new Persistente<>();
    }

    public Persistente<Aluno> getBancoAluno() {
        return this.bdAlunos;
    }

    public Persistente<Treinador> getBancoTreinador() {
        return this.bdTreinadores;
    }

    public Persistente<Ficha> getBancoFicha() {
        return this.bdFichas;
    }

    public Persistente<Exercicio> getBancoExercicio() {
        return this.bdExercicios;
    }

    public Persistente<ItemTreino> getBancoItemTreino() {
        return this.bdItensTreino;
    }
}
