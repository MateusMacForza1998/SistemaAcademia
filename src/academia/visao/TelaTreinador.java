package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class TelaTreinador extends JPanel{
    public JPanel painelForms, painelTabela, painelCRUD;
    public JLabel rotuloID,rotuloNome,rotuloIdade, rotuloCRM;
    public JTextField campoID, campoIdade, campoNome;
    private JButton botaoInserir, botao;
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    public TelaTreinador() {
        JLabel titulo = new JLabel("Painel Treinador");
        add(titulo);


        //painel do formulario
        JPanel painelForms = new JPanel();
        painelForms.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(painelForms);
        

        //campo do formulario 
        rotuloID = new JLabel("Digite a ID:");
        JTextField campoID = new JTextField(5);
        painelForms.add(rotuloID);
        painelForms.add(campoID);

        rotuloNome = new JLabel("Digite o Nome:");
        JTextField campoNome = new JTextField(25);
        painelForms.add(rotuloNome);
        painelForms.add(campoNome);

        rotuloIdade = new JLabel("Digite a Idade:");
        JTextField campoIdade = new JTextField(5);
        painelForms.add(rotuloIdade);
        painelForms.add(campoIdade);

        rotuloCRM = new JLabel("Digite a CRM:");
        JTextField campoCRM = new JTextField(5);
        painelForms.add(rotuloCRM);
        painelForms.add(campoCRM);



        //painel crud
        painelCRUD = new JPanel();
        painelCRUD.setLayout(new FlowLayout(FlowLayout.LEADING));
        add(painelCRUD);

        botaoInserir = new JButton("Inserir Treinador");
        painelCRUD.add(botaoInserir);

        botaoInserir = new JButton("Alterar Treinador");
        painelCRUD.add(botaoInserir);
        botaoInserir = new JButton("Excluir Treinador");
        painelCRUD.add(botaoInserir);
        botaoInserir = new JButton("Visualizar Treinador pela ID");
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
        modeloTabela.addColumn("CRM");

        tabela = new JTable(modeloTabela);
        tabela.getColumnModel().getColumn(0).setMaxWidth(100);
        tabela.getColumnModel().getColumn(1).setMaxWidth(900);
        tabela.getColumnModel().getColumn(2).setMaxWidth(500);
        tabela.getColumnModel().getColumn(3).setMaxWidth(500);
        painelTabela.add(tabela);

        var scroll = new JScrollPane();
        scroll.setViewportView(tabela);
        painelTabela.add(scroll);
    }
}
