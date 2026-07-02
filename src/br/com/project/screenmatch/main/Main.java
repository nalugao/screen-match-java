package br.com.project.screenmatch.main;

import br.com.project.screenmatch.calculation.CalculadoraDeTempo;
import br.com.project.screenmatch.calculation.FiltroRecomendacao;
import br.com.project.screenmatch.models.Episodio;
import br.com.project.screenmatch.models.Filme;
import br.com.project.screenmatch.models.Serie;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Perdido em marte", 2013);

        filme1.setDuracaoMinutos(154);
        filme1.exibeFichaTecnica();
        filme1.avalia(9);
        filme1.avalia(8);
        filme1.avalia(9);

        System.out.printf("Média de avaliações do filme: %.2f%n", filme1.mediaAvaliacao());

        System.out.println("-----------------");

        Serie serie1 = new Serie("Mr. Robot", 2012);
        serie1.setTemporadas(4);
        serie1.setEpisodioPorTemporada(12);
        serie1.setMinutosPorEpisodio(50);
        serie1.exibeFichaTecnica();

        System.out.println("-----------------");
        Filme filme2 = new Filme("Interestelar", 2012);
        filme2.setDuracaoMinutos(215);
        filme2.exibeFichaTecnica();
        filme2.avalia(9);
        filme2.avalia(8);
        filme2.avalia(9);

        System.out.println("-----------------");
        Filme filme3 = new Filme("Dia D", 2026);
        filme3.setDuracaoMinutos(196);
        filme3.exibeFichaTecnica();
        filme3.avalia(9);
        filme3.avalia(8);
        filme3.avalia(9);

        System.out.println("-----------------");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie1);
        System.out.println("Total de tempo para maratonar os filmes: " + calculadora.getTempoTotal());

        System.out.println("-----------------");

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);

        System.out.println("-----------------");

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie("Mr Robot");
        episodio.setTotalVisualizacao(100);
        filtro.filtra(episodio);

        System.out.println("-----------------");

    }
}