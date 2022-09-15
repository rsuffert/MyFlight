package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos () {
        voos = new ArrayList<>();
    }

    public void inserir (Voo voo) {
        voos.add(voo);
    }

    public ArrayList<Voo> pesquisarDataHora (LocalDateTime dataHora) {
        ArrayList<Voo> voosNestaDataHora = new ArrayList<>();
        
        for (Voo v : voos) {
            if (v.getDatahora().equals(dataHora)) {
                voosNestaDataHora.add(v);
            }
        }

        return voosNestaDataHora;
    }

    public ArrayList<Voo> pesquisarDuracao (Duration duracao) {
        ArrayList<Voo> voosDestaDuracao = new ArrayList<>();
        
        for (Voo v : voos) {
            if (v.getDuracao().equals(duracao)) {
                voosDestaDuracao.add(v);
            }
        }

        return voosDestaDuracao;
    }

    public ArrayList<Voo> pesquisarRota (String codigoOrigem, String codigoDestino) {
        ArrayList<Voo> voosNestaRota = new ArrayList<>();
        
        for (Voo v : voos) {
            Aeroporto origem = v.getRota().getOrigem();
            Aeroporto destino = v.getRota().getDestino();

            if (codigoOrigem.equals(origem.getCodigo()) && codigoDestino.equals(destino.getCodigo())) {
                voosNestaRota.add(v);
            }
        }

        return voosNestaRota;
    }

    public ArrayList<Voo> pesquisarOrigem (String codigoOrigem) {
        ArrayList<Voo> voosNestaOrigem = new ArrayList<>();
        
        for (Voo v : voos) {
            Aeroporto origem = v.getRota().getOrigem();

            if (codigoOrigem.equals(origem.getCodigo())) {
                voosNestaOrigem.add(v);
            }
        }

        return voosNestaOrigem;
    }

    public ArrayList<Voo> pesquisarDestino (String codigoDestino) {
        ArrayList<Voo> voosNesteDestino = new ArrayList<>();
        
        for (Voo v : voos) {
            Aeroporto destino = v.getRota().getDestino();

            if (codigoDestino.equals(destino.getCodigo())) {
                voosNesteDestino.add(v);
            }
        }

        return voosNesteDestino;
    }

    public ArrayList<Voo> pesquisarStatus (Voo.Status status) {
        ArrayList<Voo> voosComEsteStatus = new ArrayList<>();

        for (Voo v : voos) {
            if (v.getStatus().equals(status)) {
                voosComEsteStatus.add(v);
            }
        }

        return voosComEsteStatus;
    }



    public String toString () {
        String s = "";

        for (Voo v : voos) {
            s += String.format("AERONAVE: %s | ORIGEM: %s | DESTINO: %s | CIA AÉREA: %s | DECOLAGEM EM: %s.\n", 
            v.getRota().getAeronave().getCodigo(),
            v.getRota().getOrigem().getCodigo(),
            v.getRota().getDestino().getCodigo(),
            v.getDatahora().toString());
        }

        return s;
    }
        
}
