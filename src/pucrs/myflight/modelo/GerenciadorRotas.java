package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas () {
        rotas = new ArrayList<>();
    }

    public void inserir (Rota rota) {
        rotas.add(rota);
    }

    public Rota pesquisarNomeCia (String nome) {
        for (Rota r : rotas) {
            if (r.getCia().getNome().equals(nome)) {
                return r;
            }
        }

        return null;
    }

    public Rota pesquisarCodigoOrigem (String codigo) {
        for (Rota r : rotas) {
            if (r.getOrigem().getCodigo().equals(codigo)) {
                return r;
            }
        }

        return null;
    }

    public Rota pesquisarCodigoDestino (String codigo) {
        for (Rota r : rotas) {
            if (r.getDestino().getCodigo().equals(codigo)) {
                return r;
            }
        }

        return null;
    }

    public Rota pesquisarCodigoAeronave (String codigo) {
        for (Rota r : rotas) {
            if (r.getAeronave().getCodigo().equals(codigo)) {
                return r;
            }
        }

        return null;
    }

    public String toString () {
        String s = "";

        for (Rota r : rotas) {
            s += String.format("Cia: %s | Origem: %s | Destino: %s | Aeronave: %s.\n", r.getCia().getNome(), r.getOrigem().getCodigo(), r.getDestino().getCodigo(), r.getAeronave().getDescricao());
        }

        return s;
    } 

    public void ordenarPorCia() {
        Collections.sort(rotas);
    }
}
