package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import academia.modelo.Treinador;
import academia.persistencia.IdDuplicadoException;
import academia.persistencia.IdInexistenteException;

public class TelaTreinador extends JPanel {

    private JPanel painelForms, painelTabela, painelCRUD;
    private JTextField campoID, campoNome, campoIdade, campoCREF;
    private DefaultTableModel modeloTabela;
    private JTable tabela;
    private JButton botaoInserir, botaoAlterar, botaoExcluir, botaoVerID, botaoVerTodos;

    public TelaTreinador() {



        painelForms = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        add(painelForms, BorderLayout.CENTER);

        painelForms.add(new JLabel("ID:"));
        campoID = new JTextField(5);
        painelForms.add(campoID);

        painelForms.add(new JLabel("Nome:"));
        campoNome = new JTextField(20);
        painelForms.add(campoNome);

        painelForms.add(new JLabel("Idade:"));
        campoIdade = new JTextField(5);
        painelForms.add(campoIdade);

        painelForms.add(new JLabel("CRM:"));
        campoCREF = new JTextField(10);
        painelForms.add(campoCREF);
        



        painelCRUD = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        add(painelCRUD, BorderLayout.CENTER);

        botaoInserir = new JButton("Inserir Treinador");
        painelCRUD.add(botaoInserir);

        botaoAlterar = new JButton("Alterar Treinador");
        painelCRUD.add(botaoAlterar);

        botaoExcluir = new JButton("Excluir Treinador");
        painelCRUD.add(botaoExcluir);

        botaoVerID = new JButton("Buscar por ID Treinador");
        painelCRUD.add(botaoVerID);

        botaoVerTodos = new JButton("Ver Todos Treinador");
        painelCRUD.add(botaoVerTodos);



        painelTabela = new JPanel(new BorderLayout());
        add(painelTabela, BorderLayout.SOUTH);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("NOME");
        modeloTabela.addColumn("IDADE");
        modeloTabela.addColumn("CRM");

        tabela = new JTable(modeloTabela);

        JScrollPane scroll = new JScrollPane(tabela);
        painelTabela.add(scroll, BorderLayout.CENTER);


        
        configurarEventos();
    }

    private void configurarEventos() {


        
        botaoInserir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());
                String nome = campoNome.getText();
                int idade = Integer.parseInt(campoIdade.getText());
                int cref = Integer.parseInt(campoCREF.getText());

                Treinador t = new Treinador(id, nome, idade, cref);

                Programa.banco.getBancoTreinador().inserir(t);

                JOptionPane.showMessageDialog(this, "Treinador inserido com sucesso!");
                atualizarTabela();
                limparCampos();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID e idade devem ser números!");
            } catch (IdDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });


        botaoAlterar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());
                String nome = campoNome.getText();
                int idade = Integer.parseInt(campoIdade.getText());
                int cref = Integer.parseInt(campoCREF.getText());

                Treinador t = new Treinador(id, nome, idade, cref);

                Programa.banco.getBancoTreinador().alterar(t);

                JOptionPane.showMessageDialog(this, "Treinador alterado com sucesso!");
                atualizarTabela();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID e idade devem ser números!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });


        botaoExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());

                Programa.banco.getBancoTreinador().apagar(id);

                JOptionPane.showMessageDialog(this, "Treinador removido com sucesso!");
                atualizarTabela();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser um número!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });


        botaoVerID.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());

                Treinador t = Programa.banco.getBancoTreinador().buscar(id);

                modeloTabela.setRowCount(0);
                modeloTabela.addRow(new Object[]{t.getId(), t.getNome(), t.getIdade(), t.getCREF()});

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser numérico!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        
        botaoVerTodos.addActionListener(e -> atualizarTabela());
    }


    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Treinador t : Programa.banco.getBancoTreinador().listarTodos()) {
            modeloTabela.addRow(new Object[]{t.getId(), t.getNome(), t.getIdade(), t.getCREF()});
        }
    }

    private void limparCampos() {
        campoID.setText("");
        campoNome.setText("");
        campoIdade.setText("");
        campoCREF.setText("");
    }
}
