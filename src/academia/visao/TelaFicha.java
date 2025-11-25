package academia.visao;
import java.awt.*;

import javax.swing.*;

public class TelaFicha extends JPanel{
    public TelaFicha() {
        setLayout(new BorderLayout());
        add(new JLabel("TELA DO FICHA", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
