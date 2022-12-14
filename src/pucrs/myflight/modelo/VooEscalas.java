package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VooEscalas extends Voo {
    private List<Rota> rotas;

    public VooEscalas (LocalDateTime datahora) {
        super (datahora);
        rotas = new ArrayList<>();
    }

    public void adicionarRota (Rota rota) {
        rotas.add(rota);
    }

    @Override
    public Duration getDuracao () {
        final int SEGUNDOS_EM_UM_MINUTO = 60;
        final int VELOCIDADE_MEDIA_JATO = 805;
        final int TEMPO_MINUTOS_DECOLAGEM_POUSO = 30;
        final int NUMERO_DE_ESCALAS = rotas.size();
        
        double distanciaKm = 0.0;
        for (Rota r : rotas) {
            Geo locOrigem = r.getOrigem().getLocal();
            Geo locDestino = r.getDestino().getLocal();
            distanciaKm += Geo.distancia(locOrigem, locDestino);
        }

        double duracaoHorasMinutos = distanciaKm / VELOCIDADE_MEDIA_JATO;
        int duracaoHoras = (int) Math.floor(duracaoHorasMinutos);
        int duracaoMinutos = (int) ((duracaoHorasMinutos - duracaoHoras) * SEGUNDOS_EM_UM_MINUTO);

        return Duration.ofHours(duracaoHoras).plusMinutes(duracaoMinutos).plusMinutes(TEMPO_MINUTOS_DECOLAGEM_POUSO * NUMERO_DE_ESCALAS);
    }

    public List<Rota> getRotas () {
        return this.rotas;
    }

    /**
     * return primeira rota da lista de rotas
     */
    @Override
    public Rota getRota() {
        return rotas.get(0);
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();

        sb.append(rotas.get(0).getOrigem().getCodigo());
        for (Rota r : rotas) {
            sb.append(" --> ");
            sb.append(r.getDestino().getCodigo());
        }

        sb.append(" | " + super.toString());

        return sb.toString();
    }
}
