package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import academia.modelo.Exercicio;
import academia.modelo.Ficha;

public class TelaIntegracao extends JPanel {

    private JLabel rotuloFicha;
    private JComboBox<Exercicio> campoExercicio;
    private JButton botaoInserir, botaoExcluir;

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    private Ficha fichaAtual;

    public TelaIntegracao() {

        JPanel topo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        add(topo, BorderLayout.NORTH);

        rotuloFicha = new JLabel("Nenhuma ficha selecionada");
        topo.add(rotuloFicha);

        topo.add(new JLabel("Escolha o Exercício:"));
        campoExercicio = new JComboBox<>();
        topo.add(campoExercicio);

        botaoInserir = new JButton("Inserir exercício");
        topo.add(botaoInserir);

        botaoExcluir = new JButton("Excluir Exercício");
        topo.add(botaoExcluir);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("EXERCÍCIO");

        tabela = new JTable(modeloTabela);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        configurarEventos();
    }

    public void receberFicha(Ficha ficha) {
        this.fichaAtual = ficha;
        rotuloFicha.setText("Ficha " + ficha.getId() +
                " - Aluno: " + ficha.getAluno().getNome() +
                " / Treinador: " + ficha.getTreinador().getNome());

        atualizarComboExercicios();
        atualizarTabela();
    }

    private void configurarEventos() {

        botaoInserir.addActionListener(e -> {
            if (fichaAtual == null) return;

            Exercicio ex = (Exercicio) campoExercicio.getSelectedItem();
            fichaAtual.adicionarExercicio(ex);

            atualizarTabela();
        });

        botaoExcluir.addActionListener(e -> {
            if (fichaAtual == null) return;

            int row = tabela.getSelectedRow();
            if (row >= 0) {
                int idEx = (int) modeloTabela.getValueAt(row, 0);

                Exercicio paraRemover = null;

                for (Exercicio ex : fichaAtual.getExercicios()) {
                    if (ex.getId() == idEx) {
                        paraRemover = ex;
                        break;
                    }
                }

                if (paraRemover != null) {
                    fichaAtual.removerExercicio(paraRemover);
                    atualizarTabela();
                }
            }
        });
    }

    private void atualizarComboExercicios() {
        campoExercicio.removeAllItems();
        for (Exercicio ex : Programa.banco.getBancoExercicio().listarTodos()) {
            campoExercicio.addItem(ex);
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);

        if (fichaAtual == null) return;

        for (Exercicio ex : fichaAtual.getExercicios()) {
            modeloTabela.addRow(new Object[]{
                    ex.getId(),
                    ex.getNomeExercicio()
            });
        }
    }
}
