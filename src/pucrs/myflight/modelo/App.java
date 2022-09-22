package pucrs.myflight.modelo;

import java.time.LocalDateTime;

import java.time.Duration;

public class App {
    public static void main(String[] args) { 
        CiaAerea c1 = new CiaAerea("GL", "GOL LINHAS AÉREAS");

        Aeronave a1 = new Aeronave("747", "BOEING-747");
        
        Geo locGRU = new Geo(-23.4322, -46.4692);
        Geo locLHR = new Geo(51.4700223, -0.4542954999999438);

        Aeroporto guarulhos = new Aeroporto("GRU", "AEROPORTO INTERNACIONAL DE SÃO PAULO-GUARULHOS", locGRU);
        Aeroporto londres = new Aeroporto("LHR", "AEROPORTO INTERNACIONAL DE LONDRES-HEATHROW", locLHR);

        LocalDateTime dataVoo = LocalDateTime.now();
        Rota rr = new Rota(c1, guarulhos, londres, a1);
        Voo v = new VooDireto(dataVoo, rr);
        Duration duracaoI = v.getDuracao();
        System.out.println("Duração voo GRU - LHR (min): " + duracaoI.toMinutes());

        LocalDateTime dataVoo2 = LocalDateTime.now();
        Rota rr2 = new Rota(c1, londres, guarulhos, a1);
        Voo v2 = new VooEscalas(dataVoo2);
        if (v2 instanceof VooEscalas) {
            VooEscalas ve = (VooEscalas) v2;
            ve.adicionarRota(rr);
            ve.adicionarRota(rr2);
        }
        Duration duracaoII = v2.getDuracao();
        System.out.println("Duração voo GRU - LHR - GRU (min): " + duracaoII.toMinutes());
    }
}
