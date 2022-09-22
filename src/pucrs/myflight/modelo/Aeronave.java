package pucrs.myflight.modelo;

public class Aeronave implements Contavel {
	private String codigo;
	private String descricao;

	private static int qtdCriada;
	static {
		qtdCriada = 0;
	}
	
	// MÉTODO QUE DEVERIA SER IMPLEMENTADO NA INTERFACE
	@Override
	public int getQtdCriada() {
		return qtdCriada;
	}
	
	public Aeronave(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
