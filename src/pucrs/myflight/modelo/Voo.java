package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Status status;
	
	public Voo(LocalDateTime datahora) {
		this.datahora = datahora;
		this.status = Status.CONFIRMADO; // default é CONFIRMADO
	}

	public Voo() {
		this.datahora = LocalDateTime.of(2016, 8, 12, 12, 00);
		this.status = Status.CONFIRMADO; // default é CONFIRMADO
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public abstract Rota getRota();
	public abstract Duration getDuracao();

	public String toString () {

		String data = String.format("%d/%d/%d", datahora.getDayOfMonth(), datahora.getMonthValue(), datahora.getYear());
		String horario = String.format("%d:%s", datahora.getHour(), datahora.getMinute() == 0? "00" : datahora.getMinute()+"");

		StringBuilder sb = new StringBuilder();
		sb.append(status.toString() + " | "); // status do voo
		sb.append(data + " às " + horario + " | "); // data/hora do voo

		return sb.toString();
	}
}
