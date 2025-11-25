package academia.visao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class TelaAluno  extends JPanel{
    public JPanel painelForms, painelTabela, painelCRUD;
    public JLabel rotuloID,rotuloNome,rotuloIdade;
    public JTextField campoID, campoIdade, campoNome;
    private JButton botaoInserir, botao;
    private DefaultTableModel modeloTabela;
    private JTable tabela;


    public TelaAluno(){ 

        //painel do formulario
        painelForms = new JPanel();
        painelForms.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(painelForms);
        


        //campo do formulario 
        rotuloID = new JLabel("Digite sua ID:");
        campoID = new JTextField(10);
        painelForms.add(rotuloID);
        painelForms.add(campoID);

        rotuloNome = new JLabel("Digite seu Nome:");
        campoNome = new JTextField(20);
        painelForms.add(rotuloNome);
        painelForms.add(campoNome);

        rotuloIdade = new JLabel("Digite sua Idade:");
        campoIdade = new JTextField(10);
        painelForms.add(rotuloIdade);
        painelForms.add(campoIdade);



        //painel crud
        painelCRUD = new JPanel();
        painelCRUD.setLayout(new FlowLayout(FlowLayout.LEADING));
        add(painelCRUD);

        botaoInserir = new JButton("Inserir Aluno");
        painelCRUD.add(botaoInserir);

        botaoInserir = new JButton("Alterar Aluno");
        painelCRUD.add(botaoInserir);
        botaoInserir = new JButton("Excluir Aluno");
        painelCRUD.add(botaoInserir);
        botaoInserir = new JButton("Visualizar Aluno pela ID");
        painelCRUD.add(botaoInserir);
        botaoInserir = new JButton("VISUALIZAR TODOS");
        painelCRUD.add(botaoInserir);


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



    
    }
    
}


