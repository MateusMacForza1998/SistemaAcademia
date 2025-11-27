package academia.visao;

import academia.persistencia.Banco;

public class Programa {
    public static Banco banco = new Banco();

    public static void main(String[] args) {
        new JanelaPrincipal(); 
    }
}

