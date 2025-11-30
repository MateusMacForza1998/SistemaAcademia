package academia.visao;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private JButton botaoAluno, botaoTreinador, botaoExercicio, botaoFicha, botaoIntegracao;
    private JPanel painelTopo, painelTelas;
    private CardLayout card;

    // Guardar instâncias das telas
    private TelaAluno telaAluno;
    private TelaTreinador telaTreinador;
    private TelaExercicio telaExercicio;
    private TelaFicha telaFicha;
    private TelaIntegracao telaIntegracao;

    public JanelaPrincipal() {
        super("Academia - Grupo Vida");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // BOTÕES DO MENU
        painelTopo = new JPanel(new GridLayout(1,5));
        add(painelTopo, BorderLayout.NORTH);

        botaoAluno = new JButton("Painel Aluno");
        botaoTreinador = new JButton("Painel Treinador");
        botaoExercicio = new JButton("Painel Exercício");
        botaoFicha = new JButton("Painel Ficha");
        botaoIntegracao = new JButton("Painel Integração");

        painelTopo.add(botaoAluno);
        painelTopo.add(botaoTreinador);
        painelTopo.add(botaoExercicio);
        painelTopo.add(botaoFicha);
        painelTopo.add(botaoIntegracao);

        // CARDLAYOUT
        card = new CardLayout();
        painelTelas = new JPanel(card);

        // CRIA INSTÂNCIAS DAS TELAS
        telaAluno = new TelaAluno();
        telaTreinador = new TelaTreinador();
        telaExercicio = new TelaExercicio();
        telaIntegracao = new TelaIntegracao(); // <- receberá ficha depois
        telaFicha = new TelaFicha(this);       // <- recebe JanelaPrincipal

        // ADICIONAR AO CARDLAYOUT
        painelTelas.add(telaAluno, "aluno");
        painelTelas.add(telaTreinador, "treinador");
        painelTelas.add(telaExercicio, "exercicio");
        telaFicha = new TelaFicha(this);
        painelTelas.add(telaFicha, "ficha");
        painelTelas.add(telaIntegracao, "integracao");

        add(painelTelas, BorderLayout.CENTER);

        // AÇÕES DOS BOTÕES
        botaoAluno.addActionListener(e -> card.show(painelTelas, "aluno"));
        botaoTreinador.addActionListener(e -> card.show(painelTelas, "treinador"));
        botaoExercicio.addActionListener(e -> card.show(painelTelas, "exercicio"));
        botaoFicha.addActionListener(e -> card.show(painelTelas, "ficha"));
        botaoIntegracao.addActionListener(e -> card.show(painelTelas, "integracao"));
    }

    // MÉTODO PARA MUDAR PAINEL A PARTIR DE OUTRAS TELAS
    public void mudarParaPainel(String nome) {
        card.show(painelTelas, nome);
    }

    // Getter para TelaIntegracao
    public TelaIntegracao getTelaIntegracao() {
        return telaIntegracao;
    }

    public static void main(String[] args) {
        new JanelaPrincipal().setVisible(true);
    }
}
