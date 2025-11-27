package academia.visao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import academia.modelo.Aluno;
import academia.persistencia.IdInexistenteException;
import academia.visao.Programa;

public class TelaIntegração extends JPanel{

    public JPanel painelForms, painelTabela, painelCRUD;
    public JLabel rotuloID,rotuloNome,rotuloExercicio;
    private JComboBox campoExercicio,campoID;
    private JButton botaoInserir, botaoAlterar,botaoExcluir,botaoVerID,botaoVerTodos;
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    public TelaIntegração(){


        painelForms = new JPanel();
        painelForms.setLayout(new FlowLayout(FlowLayout.CENTER, 15,5));
        add(painelForms);
        


        rotuloID = new JLabel("Escolha a ID da ficha:");
        campoID = new JComboBox();
        painelForms.add(rotuloID);
        painelForms.add(campoID);

        rotuloExercicio = new JLabel("Escolha o Exercício:");
        campoExercicio = new JComboBox();
        painelForms.add(rotuloExercicio);
        painelForms.add(campoExercicio);



        painelCRUD = new JPanel();
        painelCRUD.setLayout(new FlowLayout(FlowLayout.CENTER, 15 , 5));
        add(painelCRUD);

        botaoInserir = new JButton("Inserir o exercício");
        painelCRUD.add(botaoInserir);

        botaoExcluir = new JButton("Excluir Execício");
        painelCRUD.add(botaoExcluir);


        painelTabela = new JPanel();
        painelTabela.setLayout(new BorderLayout());
        add(painelTabela, BorderLayout.SOUTH);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("EXERCÍCIOS");

        tabela = new JTable(modeloTabela);
        tabela.getColumnModel().getColumn(0).setMaxWidth(200);
        painelTabela.add(tabela);

        var scroll = new JScrollPane();
        scroll.setViewportView(tabela);
        painelTabela.add(scroll);



     

    }
    
}
