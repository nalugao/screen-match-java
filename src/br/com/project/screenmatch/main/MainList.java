package br.com.project.screenmatch.main;

import br.com.project.screenmatch.models.Filme;
import br.com.project.screenmatch.models.Serie;
import br.com.project.screenmatch.models.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainList {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Perdido em marte", 2013);
        filme1.avalia(8);
        Filme filme2 = new Filme("Interestelar", 2012);
        filme2.avalia(10);
        Filme filme3 = new Filme("Dia D", 2026);
        filme3.avalia(9);
        Serie serie1 = new Serie("Mr. Robot", 2012);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);
        for (Titulo item : lista){
            System.out.println(item.getNome());
//            Filme filme = (Filme) item;
//            System.out.println("Classificação: " + filme.getClassificacao());
        }

        ArrayList<String> buscarPorArtista = new ArrayList<>();
        buscarPorArtista.add("Elliot");
        buscarPorArtista.add("Marco");
        buscarPorArtista.add("Adam Sandler");
        buscarPorArtista.add("Angelina jolie");
        buscarPorArtista.add("Natalia");
        System.out.println(buscarPorArtista);

        Collections.sort(buscarPorArtista);
        System.out.println(buscarPorArtista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);

    }
}
