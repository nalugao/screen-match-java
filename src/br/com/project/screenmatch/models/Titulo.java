package br.com.project.screenmatch.models;

import br.com.project.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacao;
    private int duracaoMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb pesquisaOmdb) {
        this.nome = pesquisaOmdb.title();

        if (pesquisaOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("\nNão consegui converter o ano pois tem mais de 4 caracteres.");
        }

        this.anoDeLancamento = Integer.valueOf(pesquisaOmdb.year());
        this.duracaoMinutos = Integer.valueOf(pesquisaOmdb.runtime().substring(0, 2));
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoPlano() {
        return incluidoPlano;
    }

    public void setIncluidoPlano(boolean incluidoPlano) {
        this.incluidoPlano = incluidoPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome: " + getNome());
        System.out.println("Lançamento: " + getAnoDeLancamento());
        System.out.println("Duração (min): " + getDuracaoMinutos());
    }

    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalAvaliacao++;
    }

    public double mediaAvaliacao(){
        return somaAvaliacoes / totalAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nAno de Lançamento: " + getAnoDeLancamento() +
                "\nDuração: " + getDuracaoMinutos();
    }
}
