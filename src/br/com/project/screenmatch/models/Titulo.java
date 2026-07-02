package br.com.project.screenmatch.models;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacao;
    private int duracaoMinutos;

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
        System.out.println("Lançamento: " + anoDeLancamento);
        System.out.println("Duração (min): " + getDuracaoMinutos());
    }

    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalAvaliacao++;
    }

    public double mediaAvaliacao(){
        return somaAvaliacoes / totalAvaliacao;
    }
}
