package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import academia.modelo.Ficha;
import academia.modelo.Aluno;
import academia.modelo.Treinador;
import academia.persistencia.IdDuplicadoException;
import academia.persistencia.IdInexistenteException;

public class TelaFicha extends JPanel {

    private JPanel painelForms, painelCRUD, painelTabela;
    private JTextField campoID;
    private JComboBox<Aluno> campoAluno;
    private JComboBox<Treinador> campoTreinador;

    private DefaultTableModel modeloTabela;
    private JTable tabela;

    private JButton botaoInserir, botaoAlterar, botaoExcluir, botaoVerID, botaoVerTodos;

    public TelaFicha() {

        
        painelForms = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        add(painelForms, BorderLayout.NORTH);

        painelForms.add(new JLabel("ID da Ficha:"));
        campoID = new JTextField(5);
        painelForms.add(campoID);

        painelForms.add(new JLabel("Treinador:"));
        campoTreinador = new JComboBox<>();
        painelForms.add(campoTreinador);

        painelForms.add(new JLabel("Aluno:"));
        campoAluno = new JComboBox<>();
        painelForms.add(campoAluno);

        
        
        atualizarComboBoxes();

       
        painelCRUD = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        add(painelCRUD, BorderLayout.CENTER);

        botaoInserir = new JButton("Inserir");
        painelCRUD.add(botaoInserir);

        botaoAlterar = new JButton("Alterar");
        painelCRUD.add(botaoAlterar);

        botaoExcluir = new JButton("Excluir");
        painelCRUD.add(botaoExcluir);

        botaoVerID = new JButton("Buscar por ID");
        painelCRUD.add(botaoVerID);

        botaoVerTodos = new JButton("Ver Todos");
        painelCRUD.add(botaoVerTodos);
        


        painelTabela = new JPanel(new BorderLayout());
        add(painelTabela, BorderLayout.SOUTH);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("TREINADOR");
        modeloTabela.addColumn("ALUNO");

        tabela = new JTable(modeloTabela);

        JScrollPane scroll = new JScrollPane(tabela);
        painelTabela.add(scroll, BorderLayout.CENTER);

        configurarEventos();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                atualizarComboBoxes();
            }
        });
}
        



    private void configurarEventos() {

        

        botaoInserir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoID.getText());

                Treinador treinador = (Treinador) campoTreinador.getSelectedItem();
                Aluno aluno = (Aluno) campoAluno.getSelectedItem();

                Ficha ficha = new Ficha(id, aluno, treinador);

                Programa.banco.getBancoFicha().inserir(ficha);

                JOptionPane.showMessageDialog(this, "Ficha criada com sucesso!");
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

                Treinador treinador = (Treinador) campoTreinador.getSelectedItem();
                Aluno aluno = (Aluno) campoAluno.getSelectedItem();

                Ficha ficha = new Ficha(id, aluno, treinador);

                Programa.banco.getBancoFicha().alterar(ficha);

                JOptionPane.showMessageDialog(this, "Ficha alterada com sucesso!");
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

                Programa.banco.getBancoFicha().apagar(id);

                JOptionPane.showMessageDialog(this, "Ficha removida com sucesso!");
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
                Ficha ficha = Programa.banco.getBancoFicha().buscar(id);

                modeloTabela.setRowCount(0);
                modeloTabela.addRow(new Object[]{
                    ficha.getId(),
                    ficha.getTreinador().getNome(),
                    ficha.getAluno().getNome(),
                    ficha.getExercicios().size()
                });

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID deve ser número!");
            } catch (IdInexistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });


        botaoVerTodos.addActionListener(e -> atualizarTabela());
    }
    
    


    private void atualizarComboBoxes() {
        campoAluno.removeAllItems();
        campoTreinador.removeAllItems();

        for (Aluno a : Programa.banco.getBancoAluno().listarTodos()) {
            campoAluno.addItem(a);
        }

        for (Treinador t : Programa.banco.getBancoTreinador().listarTodos()) {
            campoTreinador.addItem(t);
        }
    }

    


    private void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (Ficha f : Programa.banco.getBancoFicha().listarTodos()) {
            modeloTabela.addRow(new Object[]{
                f.getId(),
                f.getTreinador().getNome(),
                f.getAluno().getNome(),
                f.getExercicios().size()
            });
        }
    }

    private void limparCampos() {
        campoID.setText("");
        atualizarComboBoxes();
    }
    
}
