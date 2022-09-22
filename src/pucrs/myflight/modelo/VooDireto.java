package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.time.Duration;

public class VooDireto extends Voo {
    private Rota rota;

    public VooDireto (LocalDateTime dataHora, Rota rota) {
        super(dataHora);
        this.rota = rota;
    }

    @Override
    public Duration getDuracao() {
        final int SEGUNDOS_EM_UM_MINUTO = 60;
        final int VELOCIDADE_MEDIA_JATO = 805;
        final int TEMPO_MINUTOS_DECOLAGEM_POUSO = 30;
        
        Geo locOrigem = rota.getOrigem().getLocal();
        Geo locDestino = rota.getDestino().getLocal();

        double distanciaKm = Geo.distancia(locOrigem, locDestino);

        double duracaoHorasMinutos = distanciaKm / VELOCIDADE_MEDIA_JATO;
        int duracaoHoras = (int) Math.floor(duracaoHorasMinutos);
        int duracaoMinutos = (int) ((duracaoHorasMinutos - duracaoHoras) * SEGUNDOS_EM_UM_MINUTO);

        return Duration.ofHours(duracaoHoras).plusMinutes(duracaoMinutos+TEMPO_MINUTOS_DECOLAGEM_POUSO);
    }

    @Override
    public Rota getRota() {
        return this.rota;
    }
}
