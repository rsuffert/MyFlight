package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import pucrs.myflight.modelo.Voo.Status;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        CiaAerea c1 = new CiaAerea("GL", "GOL LINHAS AÉREAS");
        CiaAerea c2 = new CiaAerea("LA", "LATAM LINHAS AÉREAS");
        CiaAerea c3 = new CiaAerea("AZ", "AZUL CIA AÉREA BRASILEIRA");

        Aeronave a1 = new Aeronave("747", "BOEING-747");
        Aeronave a2 = new Aeronave("130", "BOMBARDIER A-130");
        
        Geo locGRU = new Geo(-23.4322, -46.4692);
        Geo locLHR = new Geo(51.4700223, -0.4542954999999438);

        Aeroporto guarulhos = new Aeroporto("GRU", "AEROPORTO INTERNACIONAL DE SÃO PAULO-GUARULHOS", locGRU);
        Aeroporto londres = new Aeroporto("LHR", "AEROPORTO INTERNACIONAL DE LONDRES-HEATHROW", locLHR);

        Rota r1 = new Rota(c2, guarulhos, londres, a1);

        LocalDateTime dataHora = LocalDateTime.of(2022, 8, 26, 15, 00);
        Duration duracao = Duration.ofHours(12);
        
        Voo v1 = new Voo(r1, dataHora, duracao);
        v1.setStatus(Status.CONFIRMADO);

        System.out.printf("Distância da viagem (origem - destino): %.2f km.\n", Geo.distancia(locGRU, locLHR));
        System.out.println(v1);

        // TESTE DE VOOS COM MÚLTIPLAS ESCALAS
        Geo locBER = new Geo(52.3666667, 13.5033333);
        Geo locDME = new Geo (55.414566, 53.9696);
        
        Aeroporto berlim = new Aeroporto("BER", "AEROPORTO DE BERLIM-BRANDEMBURGO", locBER);
        Aeroporto domodedovo = new Aeroporto("DME", "AEROPORTO INTERNACIONAL DE DOMODEDOVO", locDME);

        Rota r2 = new Rota(c2, londres, berlim, a2);
        Rota r3 = new Rota(c2, berlim, domodedovo, a2);

        ArrayList<Rota> r = new ArrayList<>();
        r.add(r2);
        r.add(r3);

        LocalDateTime dataHora2 = LocalDateTime.of(2022, 04, 9, 9, 30);

        Voo v2 = new VooVariasEscalas(r1, r, dataHora2, duracao);
        System.out.println(v2);

        GerenciadorRotas gerRot = new GerenciadorRotas();
        gerRot.inserir(r1);
        gerRot.inserir(r2);
        gerRot.inserir(r3);
        gerRot.ordenarPorCia();

        GerenciadorAeroportos gerAero = new GerenciadorAeroportos();
        gerAero.inserir(guarulhos);
        gerAero.inserir(berlim);
        gerAero.inserir(londres);
        gerAero.inserir(domodedovo);
        gerAero.ordenarPorNome();

        System.out.println(gerRot);
        System.out.println(gerAero);
    }
}
