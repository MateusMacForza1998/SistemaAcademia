package academia.visao;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {

    private JButton botaoAluno, botaoTreinador, botaoExercicio, botaoFicha;
    private JPanel painelTopo,painelTelas;// botoes e os paineis que mudam
    private CardLayout card;

    public JanelaPrincipal() {
        super("Academia - Grupo Vida");
        setSize(1080, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //botoes do menu
        painelTopo = new JPanel(new GridLayout(1,4));
        add(painelTopo, BorderLayout.NORTH);
        botaoAluno = new JButton("Painel Aluno");
        botaoTreinador = new JButton("Painel Treinador");
        botaoExercicio = new JButton("Painel Exercício");
        botaoFicha = new JButton("Painel Ficha");
        painelTopo.add(botaoAluno);
        painelTopo.add(botaoTreinador);
        painelTopo.add(botaoExercicio);
        painelTopo.add(botaoFicha);

        // painel de telas
        card = new CardLayout();
        painelTelas = new JPanel(card);

        // adiciona um painel 
        painelTelas.add(new TelaAluno(), "Aluno");
        painelTelas.add(new TelaTreinador(), "treinador");
        painelTelas.add(new TelaExercicio(), "exercicio");
        painelTelas.add(new TelaFicha(), "ficha");
        add(painelTelas, BorderLayout.CENTER);

        // açao apos apertar os botoes
        botaoAluno.addActionListener(e -> card.show(painelTelas, "aluno"));
        botaoTreinador.addActionListener(e -> card.show(painelTelas, "treinador"));
        botaoExercicio.addActionListener(e -> card.show(painelTelas, "exercicio"));
        botaoFicha.addActionListener(e -> card.show(painelTelas, "ficha"));
    }

    public static void main(String[] args) {
        new JanelaPrincipal().setVisible(true);
    }
}
