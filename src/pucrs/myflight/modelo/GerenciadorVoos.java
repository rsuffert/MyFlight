package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos () {
        voos = new ArrayList<>();
    }

    public void inserir (Voo voo) {
        voos.add(voo);
    }

    /*
    public Voo pesquisar () {
        
    }

    public String toString () {

    }
    */
        
}
