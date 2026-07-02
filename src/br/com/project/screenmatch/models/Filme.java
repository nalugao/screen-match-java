package br.com.project.screenmatch.models;

import br.com.project.screenmatch.calculation.Classificavel;

public class Filme extends Titulo implements Classificavel {

    @Override
    public int getClassificacao() {
        return (int) mediaAvaliacao() / 2;
    }
}

