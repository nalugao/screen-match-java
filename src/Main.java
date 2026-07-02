import br.com.project.screenmatch.models.CalculadoraDeTempo;
import br.com.project.screenmatch.models.Filme;
import br.com.project.screenmatch.models.Serie;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme();
        Serie serie1 = new Serie();

        filme1.setNome("Perdido em marte");
        filme1.setAnoDeLancamento(2013);
        filme1.setDuracaoMinutos(154);
        filme1.exibeFichaTecnica();
        filme1.avalia(9);
        filme1.avalia(8);
        filme1.avalia(9);

        System.out.printf("Média de avaliações do filme: %.2f%n", filme1.mediaAvaliacao());

        System.out.println("-----------------");

        serie1.setNome("Mr. Robot");
        serie1.setAnoDeLancamento(2012);
        serie1.setTemporadas(4);
        serie1.setEpisodioPorTemporada(12);
        serie1.setMinutosPorEpisodio(50);
        serie1.exibeFichaTecnica();

        System.out.println("-----------------");
        Filme filme2 = new Filme();
        filme2.setNome("Interestelar");
        filme2.setAnoDeLancamento(2013);
        filme2.setDuracaoMinutos(215);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie1);
        System.out.println("Total de tempo para maratonar os filmes: " + calculadora.getTempoTotal());
    }
}