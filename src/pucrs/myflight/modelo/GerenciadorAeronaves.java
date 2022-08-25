package pucrs.myflight.modelo;
import java.util.ArrayList;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves () {
        aeronaves = new ArrayList<>();
    }

    public void inserir (Aeronave aero) {
        this.aeronaves.add(aero);
    }

    public Aeronave pesquisar (String codigo) {
        for (Aeronave a : aeronaves) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }

        return null;
    }

    public String toString () {
        String s = "";
        
        for (Aeronave a : aeronaves) {
            s += String.format("Código: %s | Descrição: %s.\n", a.getCodigo(), a.getDescricao());
        }

        return s;
    }

}
