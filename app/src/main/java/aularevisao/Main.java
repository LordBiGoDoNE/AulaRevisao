package aularevisao;

import aularevisao.gui.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        Conexao.iniciarBanco("localhost", "18745", "postgres", "postgres", "VrPost@Server");
        
        TelaPrincipal form = new TelaPrincipal();
        form.setVisible(true);
    }
}
