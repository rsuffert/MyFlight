package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo {
    private ArrayList<Rota> rotasFinais;

    public VooVariasEscalas (Rota rotaInicial, ArrayList<Rota> rotasFinais, LocalDateTime dataHoraVooInicial, Duration duracaoVooInicial) {
        super(rotaInicial, dataHoraVooInicial, duracaoVooInicial);
        this.rotasFinais = rotasFinais;
    }

    public ArrayList<Rota> getRotasFinais () {
        return rotasFinais;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder(super.toString());

        for (Rota r : rotasFinais) {
            sb.append(" --> ");
            sb.append(r.getDestino().getCodigo());
        }

        return sb.toString();
    }
}
