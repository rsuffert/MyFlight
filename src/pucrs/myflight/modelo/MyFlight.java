package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MyFlight {
    private GerenciadorAeronaves aeronaves = new GerenciadorAeronaves();
    private GerenciadorAeroportos aeroportos = new GerenciadorAeroportos();
    private GerenciadorCias companhias = new GerenciadorCias();
    private GerenciadorRotas rotas = new GerenciadorRotas();
    private GerenciadorVoos voos = new GerenciadorVoos();

    public void criarAeronave(String codigo, String descricao) {
        aeronaves.inserir(new Aeronave(codigo, descricao));
    }

    public void criarAeroporto (String codigo, String nome, String latitude, String longitude) {
        Geo loc = new Geo(Double.parseDouble(latitude), Double.parseDouble(longitude));
        aeroportos.inserir(new Aeroporto(codigo, nome, loc));
    }

    public void criarCiaAerea (String codigo, String nome) {
        companhias.inserir(new CiaAerea(codigo, nome));
    }

    public void criarRota (CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
        rotas.inserir(new Rota(cia, origem, destino, aeronave));
    }

    public Aeronave localizarAeronave (String codigo) {
        return aeronaves.pesquisar(codigo);
    }

    public Aeroporto localizarAeroporto (String codigo) {
        return aeroportos.pesquisarCodigo(codigo);
    }

    public CiaAerea localizarCompanhia (String codigo) {
        return companhias.pesquisarCodigo(codigo);
    }

    public Rota localizarRotaPorCia (String nomeCia) {
        return rotas.pesquisarNomeCia(nomeCia);
    }

    public Rota localizarRotaPorOrigem (String codigoOrigem) {
        return rotas.pesquisarCodigoOrigem(codigoOrigem);
    }

    public Rota localizarRotaPorDestino (String codigoDestino) {
        return rotas.pesquisarCodigoDestino(codigoDestino);
    }

    public Rota localizarRotaPorCodigoAeronave (String codigoAeronave) {
        return rotas.pesquisarCodigoAeronave(codigoAeronave);
    }

    public ArrayList<Voo> localizarVooPorDataHora (LocalDateTime dataHora) {
        return voos.pesquisarDataHora(dataHora);
    }

    public ArrayList<Voo> localizarVooPorDuracao (Duration duracao) {
        return voos.pesquisarDuracao(duracao);
    }

    public ArrayList<Voo> localizarVooPorRota (String codigoOrigem, String codigoDestino) {
        return voos.pesquisarRota(codigoOrigem, codigoDestino);
    }

    public ArrayList<Voo> localizarVooPorOrigem (String codigoOrigem) {
        return voos.pesquisarOrigem(codigoOrigem);
    }

    public ArrayList<Voo> localizarVooPorDestino (String codigoDestino) {
        return voos.pesquisarDestino(codigoDestino);
    }

    public ArrayList<Voo> localizarVooPorStatus (Voo.Status status) {
        return voos.pesquisarStatus(status);
    }
    
}