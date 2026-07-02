package br.com.project.screenmatch.calculation;

import br.com.project.screenmatch.models.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal(){
        return tempoTotal;
    }

    public void inclui(Titulo t){
        this.tempoTotal += t.getDuracaoMinutos();
    }
}
