package academia.visao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import academia.modelo.Aluno;
import academia.persistencia.IdDuplicadoException;
import academia.persistencia.IdInexistenteException;
import academia.visao.Programa;



public class TelaAluno  extends JPanel{
    public JPanel painelForms, painelTabela, painelCRUD;
    public JLabel rotuloID,rotuloNome,rotuloIdade;
    public JTextField campoID, campoIdade, campoNome;
    private JButton botaoInserir, botaoAlterar,botaoExcluir,botaoVerID,botaoVerTodos;
    private DefaultTableModel modeloTabela;
    private JTable tabela;


    public TelaAluno(){ 

        //painel do formulario
        painelForms = new JPanel();
        painelForms.setLayout(new FlowLayout(FlowLayout.CENTER, 15,5));
        add(painelForms);
        


        //campo do formulario 
        rotuloID = new JLabel("Digite a ID:");
        campoID = new JTextField(10);
        painelForms.add(rotuloID);
        painelForms.add(campoID);

        rotuloNome = new JLabel("Digite o Nome:");
        campoNome = new JTextField(20);
        painelForms.add(rotuloNome);
        painelForms.add(campoNome);

        rotuloIdade = new JLabel("Digite a Idade:");
        campoIdade = new JTextField(10);
        painelForms.add(rotuloIdade);
        painelForms.add(campoIdade);



        //painel crud
        painelCRUD = new JPanel();
        painelCRUD.setLayout(new FlowLayout(FlowLayout.CENTER, 15 , 5));
        add(painelCRUD);

        botaoInserir = new JButton("Inserir Aluno");
        painelCRUD.add(botaoInserir);

        botaoAlterar = new JButton("Alterar Aluno");
        painelCRUD.add(botaoAlterar);
        botaoExcluir = new JButton("Excluir Aluno");
        painelCRUD.add(botaoExcluir);
        botaoVerID = new JButton("Visualizar Aluno pela ID");
        painelCRUD.add(botaoVerID);
        botaoVerTodos = new JButton("Visualizar Todos");
        painelCRUD.add(botaoVerTodos);


        //tabela dos açluno 
        painelTabela = new JPanel();
        painelTabela.setLayout(new BorderLayout());
        add(painelTabela, BorderLayout.SOUTH);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("NOME");
        modeloTabela.addColumn("IDADE");

        tabela = new JTable(modeloTabela);
        tabela.getColumnModel().getColumn(0).setMaxWidth(200);
        tabela.getColumnModel().getColumn(1).setMaxWidth(900);
        tabela.getColumnModel().getColumn(2).setMaxWidth(500);
        painelTabela.add(tabela);

        var scroll = new JScrollPane();
        scroll.setViewportView(tabela);
        painelTabela.add(scroll);



        
        operacaoEventos();
    }
    
    private void operacaoEventos() {

   
    botaoInserir.addActionListener(e -> {
        try {
            int id = Integer.parseInt(campoID.getText());
            String nome = campoNome.getText();
            int idade = Integer.parseInt(campoIdade.getText());

            Aluno aluno = new Aluno(id, nome, idade);

            Programa.banco.getBancoAluno().inserir(aluno);

            JOptionPane.showMessageDialog(this, "Aluno inserido com sucesso!");
            atualizarTabela();
            limparCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID e Idade devem ser números!");
        } catch (IdDuplicadoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    });


    
    botaoAlterar.addActionListener(e -> {
        try {
            int id = Integer.parseInt(campoID.getText());
            String nome = campoNome.getText();
            int idade = Integer.parseInt(campoIdade.getText());

            Aluno aluno = new Aluno(id, nome, idade);

            Programa.banco.getBancoAluno().alterar(aluno);

            JOptionPane.showMessageDialog(this, "Aluno alterado com sucesso!");
            atualizarTabela();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID e Idade devem ser números!");
        } catch (IdInexistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    });



    botaoExcluir.addActionListener(e -> {
        try {
            int id = Integer.parseInt(campoID.getText());

            Programa.banco.getBancoAluno().apagar(id);

            JOptionPane.showMessageDialog(this, "Aluno removido com sucesso!");
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

            Aluno a = Programa.banco.getBancoAluno().buscar(id);

            modeloTabela.setRowCount(0);
            modeloTabela.addRow(new Object[]{a.getId(), a.getNome(), a.getIdade()});

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID deve ser um número!");
        } catch (IdInexistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    });



    botaoVerTodos.addActionListener(e -> atualizarTabela());
}

    private void atualizarTabela() {
        modeloTabela.setRowCount(0); 
        for (Aluno a : Programa.banco.getBancoAluno().listarTodos()) {
            modeloTabela.addRow(new Object[]{a.getId(), a.getNome(), a.getIdade()});
        }
    }



    private void limparCampos() {
        campoID.setText("");
        campoNome.setText("");
        campoIdade.setText("");
    }
}



