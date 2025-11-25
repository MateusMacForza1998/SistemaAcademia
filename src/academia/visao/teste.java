package academia.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class teste extends JPanel {
    public JPanel painelForms, painelTabela;
    public JLabel rotuloID, rotuloNome, rotuloIdade;
    public JTextField campoID, campoIdade, campoNome;
    private JButton botaoEnviar;
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    public teste() {
        // 1. Configura o layout principal do TelaAluno para BorderLayout
        // O BorderLayout é ideal para dividir a tela em áreas (Norte, Sul, Leste, Oeste, Centro)
        this.setLayout(new BorderLayout());

        // --- Configuração do Painel de Formulário (Norte) ---

        // Configura o painel do formulário usando GridLayout ou FlowLayout agrupado
        painelForms = new JPanel();
        // Usamos GridLayout ou BoxLayout para organizar melhor os campos,
        // mas vamos manter o FlowLayout para simplificar, agrupando rótulo e campo.
        // Usaremos um JPanel interno para os campos ficarem organizados em uma coluna.
        JPanel camposPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 linhas, 2 colunas, espaçamento de 5

        rotuloID = new JLabel("Digite sua ID:");
        campoID = new JTextField(10);
        camposPanel.add(rotuloID);
        camposPanel.add(campoID);

        rotuloNome = new JLabel("Digite seu Nome:");
        campoNome = new JTextField(20);
        camposPanel.add(rotuloNome);
        camposPanel.add(campoNome);

        rotuloIdade = new JLabel("Digite sua Idade:");
        campoIdade = new JTextField(10);
        camposPanel.add(rotuloIdade);
        camposPanel.add(campoIdade);

        botaoEnviar = new JButton("Salvar Aluno");
        // Adiciona um espaço vazio no grid para alinhar o botão.
        camposPanel.add(new JLabel(""));
        camposPanel.add(botaoEnviar);
        
        painelForms.add(camposPanel); // Adiciona o painel de campos ao painelForms

        // Adiciona o formulário na região NORTE (Topo) do TelaAluno
        this.add(painelForms, BorderLayout.NORTH);

        // --- Configuração da Tabela (Centro) ---
        
        // 2. Cria o modelo e a JTable
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("NOME");
        modeloTabela.addColumn("IDADE");

        tabela = new JTable(modeloTabela);
        // Dimensões de coluna não são estritamente necessárias, mas podem ajudar.
        // Note que o JScrollPane cuidará da exibição.
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(70);

        // 3. ENVOLVE A TABELA EM UM JSCROLLPANE (Ponto Crucial)
        // O JScrollPane garante que os cabeçalhos da tabela sejam exibidos e que a
        // funcionalidade de rolagem exista se a tabela for muito grande.
        JScrollPane scrollPane = new JScrollPane(tabela);

        painelTabela = new JPanel(new BorderLayout()); // Usa BorderLayout para o painelTabela
        // Adiciona o JScrollPane (que contém a tabela) ao painelTabela
        painelTabela.add(scrollPane, BorderLayout.CENTER);

        // 4. Adiciona o painel da tabela na região CENTRAL do TelaAluno
        // A região CENTER do BorderLayout ocupará todo o espaço restante e se
        // redimensionará com a janela.
        this.add(painelTabela, BorderLayout.CENTER);
        
        // Adiciona um dado de exemplo para ver a tabela funcionando
        modeloTabela.addRow(new Object[]{"1", "João da Silva", "25"});
    }

    // --- Método main de exemplo para teste ---
    public static void main(String[] args) {
        // Cria um JFrame (janela principal)
        JFrame frame = new JFrame("Gerenciamento de Alunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));

        // Cria e adiciona a sua tela de aluno
        TelaAluno tela = new TelaAluno();
        frame.add(tela);

        // Ajusta o tamanho da janela para caber os componentes e a exibe
        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }
}