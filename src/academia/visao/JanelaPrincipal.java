package academia.visao;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {

    private JButton botaoAluno, botaoTreinador, botaoExercicio, botaoFicha, botaoIntegracao;
    private JPanel painelTopo,painelTelas;
    private CardLayout card;

    public JanelaPrincipal() {
        super("Academia - Grupo Vida");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //botoes do menu
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

        // painel de telas
        card = new CardLayout();
        painelTelas = new JPanel(card);

        // adiciona um painel 
        painelTelas.add(new TelaAluno(), "aluno");
        painelTelas.add(new TelaTreinador(), "treinador");
        painelTelas.add(new TelaExercicio(), "exercicio");
        painelTelas.add(new TelaFicha(), "ficha");
        painelTelas.add(new TelaIntegração(), "integracao");
        add(painelTelas, BorderLayout.CENTER);

        // açao apos apertar os botoes
        botaoAluno.addActionListener(e -> card.show(painelTelas, "aluno"));
        botaoTreinador.addActionListener(e -> card.show(painelTelas, "treinador"));
        botaoExercicio.addActionListener(e -> card.show(painelTelas, "exercicio"));
        botaoFicha.addActionListener(e -> card.show(painelTelas, "ficha"));
        botaoIntegracao.addActionListener(e -> card.show(painelTelas, "integracao"));
    }

    public static void main(String[] args) {
        new JanelaPrincipal().setVisible(true);
    }
}
