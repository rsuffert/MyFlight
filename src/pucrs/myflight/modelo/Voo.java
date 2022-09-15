package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é CONFIRMADO
	}

	public Voo(Rota rota, Duration duracao) {
		this.rota = rota;
		this.datahora = LocalDateTime.of(2016, 8, 12, 12, 00);
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é CONFIRMADO
	}
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public String toString () {

		String data = String.format("%d/%d/%d", datahora.getDayOfMonth(), datahora.getMonthValue(), datahora.getYear());
		String horario = String.format("%d:%s", datahora.getHour(), datahora.getMinute() == 0? "00" : datahora.getMinute()+"");

		// COMPANHIA | STATUS | DATA/HORA | ORIGEM --> DESTINO
		StringBuilder sb = new StringBuilder();
		sb.append(rota.getCia().getNome() + " | "); // nome da companhia
		sb.append(status.toString() + " | "); // status do voo
		sb.append(data + " às " + horario + " | "); // data/hora do voo
		sb.append(rota.getOrigem().getCodigo() + " --> " + rota.getDestino().getCodigo());

		return sb.toString();
	}
}
