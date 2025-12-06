package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import academia.modelo.Exercicio;
import academia.modelo.Ficha;
import academia.modelo.ItemTreino;

public class TelaIntegracao extends JPanel {

    private JLabel rotuloFicha;
    private JComboBox<Exercicio> campoExercicio;
    private JComboBox<Integer> campoSerie;
    private JComboBox<Integer> campoRepeticao;

    private JButton botaoInserir, botaoExcluir;

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    private Ficha fichaAtual;

    public TelaIntegracao() {

        JPanel topo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        add(topo, BorderLayout.NORTH);

        rotuloFicha = new JLabel("Nenhuma ficha selecionada");
        topo.add(rotuloFicha);

        topo.add(new JLabel("Exercício:"));
        campoExercicio = new JComboBox<>();
        topo.add(campoExercicio);

        topo.add(new JLabel("Séries:"));
        campoSerie = new JComboBox<>(new Integer[]{1,2,3,4,5});
        topo.add(campoSerie);

        topo.add(new JLabel("Repetições:"));
        campoRepeticao = new JComboBox<>(new Integer[]{5,8,10,12,15,20});
        topo.add(campoRepeticao);

        botaoInserir = new JButton("Inserir");
        topo.add(botaoInserir);

        botaoExcluir = new JButton("Excluir");
        topo.add(botaoExcluir);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("EXERCÍCIO");
        modeloTabela.addColumn("SÉRIE");
        modeloTabela.addColumn("REPETIÇÃO");

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

        // Inserir ItemTreino na Ficha
        botaoInserir.addActionListener(e -> {
            if (fichaAtual == null) return;

            Exercicio ex = (Exercicio) campoExercicio.getSelectedItem();
            int serie = (int) campoSerie.getSelectedItem();
            int repeticao = (int) campoRepeticao.getSelectedItem();

            int novoId = gerarIdItem(); // Gerar ID autom.

            ItemTreino item = new ItemTreino(novoId, ex, serie, repeticao);
            fichaAtual.adicionarItem(item);

            atualizarTabela();
        });

        // Excluir item selecionado
        botaoExcluir.addActionListener(e -> {
            if (fichaAtual == null) return;

            int row = tabela.getSelectedRow();
            if (row >= 0) {

                int idItem = (int) modeloTabela.getValueAt(row, 0);

                ItemTreino paraRemover = null;

                for (ItemTreino it : fichaAtual.getItens()) {
                    if (it.getId() == idItem) {
                        paraRemover = it;
                        break;
                    }
                }

                if (paraRemover != null) {
                    fichaAtual.removerItem(paraRemover);
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

        for (ItemTreino item : fichaAtual.getItens()) {
            modeloTabela.addRow(new Object[]{
                    item.getId(),
                    item.getExercicio().getNomeExercicio(),
                    item.getSerie(),
                    item.getRepeticao()
            });
        }
    }

    private int gerarIdItem() {
        int maior = 0;
        for (ItemTreino it : fichaAtual.getItens()) {
            if (it.getId() > maior) maior = it.getId();
        }
        return maior + 1;
    }
}
