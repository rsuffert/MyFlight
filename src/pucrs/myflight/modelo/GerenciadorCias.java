package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}


    public void inserir (CiaAerea cia) {
		empresas.add(cia);
    }

    public CiaAerea pesquisarCodigo (String codigo) {
		for (CiaAerea c : empresas) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}
		}

		return null;
    }

    public CiaAerea pesquisarNome (String nome) {
		for (CiaAerea c : empresas) {
			if (c.getNome().equals(nome)) {
				return c;
			}
		}

		return null;
    }

    public String toString () {
		String s = "";

		for (CiaAerea c : empresas) {
			s += String.format("Código: %s | Nome: %s.\n", c.getCodigo(), c.getNome());
		}

		return s;
    } 
}
