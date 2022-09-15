package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos () {
        aeroportos = new ArrayList<>();
    }

    public void inserir (Aeroporto aero) {
        aeroportos.add(aero);
    }

    public Aeroporto pesquisarCodigo (String codigo) {
        for (Aeroporto a : aeroportos) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }

        return null;
    }

    public Aeroporto pesquisarNome (String nome) {
        for (Aeroporto a : aeroportos) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }

        return null;
    }

    public String toString () {
        String s = "";

        for (Aeroporto a : aeroportos) {
            s += String.format("Código: %s | Nome: %s | Localização: LAT %f ; LON %f.\n", a.getCodigo(), a.getNome(), a.getLocal().getLatitude(), a.getLocal().getLongitude());
        }

        return s;
    } 

    public void ordenarPorNome() {
        Collections.sort(aeroportos);
    }

    public void ordenarPorCodigo() {
        Collections.sort(aeroportos, Aeroporto.getComparatorCodigo());
    }
}
