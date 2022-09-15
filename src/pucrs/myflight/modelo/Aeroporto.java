package pucrs.myflight.modelo;

import java.util.Comparator;

public class Aeroporto implements Comparable<Aeroporto>{
	private String codigo;
	private String nome;
	private Geo loc;
	
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Geo getLocal() {
		return loc;
	}

	@Override
	public int compareTo(Aeroporto outro) {
		return this.nome.compareTo(outro.nome);
	}

	public static Comparator<Aeroporto> getComparatorCodigo() {
		return new Comparator<Aeroporto> () {
			@Override
			public int compare (Aeroporto a1, Aeroporto a2) {
				return a1.getCodigo().compareTo(a2.getCodigo());
			}
		};
	}
}
