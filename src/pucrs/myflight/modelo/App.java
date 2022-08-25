package pucrs.myflight.modelo;

import java.time.LocalDateTime;

import pucrs.myflight.modelo.Voo.Status;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        CiaAerea c1 = new CiaAerea("GL", "GOL LINHAS AÉREAS");
        CiaAerea c2 = new CiaAerea("LA", "LATAM LINHAS AÉREAS");
        CiaAerea c3 = new CiaAerea("AZ", "AZUL CIA AÉREA BRASILEIRA");

        Aeronave a1 = new Aeronave("747", "BOEING-747");
        Aeronave a2 = new Aeronave("130", "BOMBARDIER A-130");
        
        Geo locGru = new Geo(-23.4322, -46.4692);
        Geo locLHR = new Geo(51.4700223, -0.4542954999999438);

        Aeroporto guarulhos = new Aeroporto("GRU", "AEROPORTO INTERNACIONAL DE SÃO PAULO-GUARULHOS", locGru);
        Aeroporto londres = new Aeroporto("LHR", "AEROPORTO INTERNACIONAL DE LONDRES-HEATHROW", locLHR);

        Rota r1 = new Rota(c2, guarulhos, londres, a1);

        LocalDateTime dataHora = LocalDateTime.of(2022, 8, 26, 15, 00);
        Duration duracao = Duration.ofHours(12);
        
        Voo v1 = new Voo(r1, dataHora, duracao);
        v1.setStatus(Status.CONFIRMADO);
    }
}