package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import academia.modelo.Exercicio;
import academia.persistencia.IdDuplicadoException;
import academia.persistencia.IdInexistenteException;

public class TelaExercicio extends JPanel {

    private JPanel painelForms, painelCRUD, painelTabela;
    private JTextField campoID, campoNome;
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    private JButton botaoInserir, botaoAlterar, botaoExcluir, botaoVerID, botaoVerTodos;

    public TelaExercicio() {


        

        painelForms = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        add(painelForms, BorderLayout.CENTER);

        painelForms.add(new JLabel("ID:"));
        campoID = new JTextField(5);
        painelForms.add(campoID);

        painelForms.add(new JLabel("Nome do Exercício:"));
        campoNome = new JTextField(25);
        painelForms.add(campoNome);
        


        painelCRUD = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        add(painelCRUD, BorderLayout.CENTER);

        botaoInserir = new JButton("Inserir Exercício");
        painelCRUD.add(botaoInserir);

        botaoAlterar = new JButton("Alterar Exercício");
        painelCRUD.add(botaoAlterar);

        botaoExcluir = new JButton("Excluir Exercício");
        painelCRUD.add(botaoExcluir);

        botaoVerID = new JButton("Buscar por ID Exercício");
        painelCRUD.add(botaoVerID);

        botaoVerTodos = new JButton("Ver Todos Exercício");
        painelCRUD.add(botaoVerTodos);

        
        painelTabela = new JPanel(new BorderLayout());
        add(painelTabela, BorderLayout.SOUTH);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("EXERCÍCIO");

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

                Exercicio ex = new Exercicio(id, nome);

                Programa.banco.getBancoExercicio().inserir(ex);

                JOptionPane.showMessageDialog(this, "Exercício inserido com sucesso!");
                atualizarTabela();
                limparCampos();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser número!");
            } catch (IdDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });



        botaoAlterar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());
                String nome = campoNome.getText();

                Exercicio ex = new Exercicio(id, nome);

                Programa.banco.getBancoExercicio().alterar(ex);

                JOptionPane.showMessageDialog(this, "Exercício alterado com sucesso!");
                atualizarTabela();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser número!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });



        botaoExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());

                Programa.banco.getBancoExercicio().apagar(id);

                JOptionPane.showMessageDialog(this, "Exercício removido com sucesso!");
                atualizarTabela();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser número!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });



        botaoVerID.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());

                Exercicio ex = Programa.banco.getBancoExercicio().buscar(id);

                modeloTabela.setRowCount(0);
                modeloTabela.addRow(new Object[]{
                        ex.getId(), ex.getNomeExercicio()
                });

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser número!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        botaoVerTodos.addActionListener(e -> atualizarTabela());
    }


    private void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (Exercicio ex : Programa.banco.getBancoExercicio().listarTodos()) {
            modeloTabela.addRow(new Object[]{
                    ex.getId(), ex.getNomeExercicio()
            });
        }
    }

    private void limparCampos() {
        campoID.setText("");
        campoNome.setText("");
    }
}
