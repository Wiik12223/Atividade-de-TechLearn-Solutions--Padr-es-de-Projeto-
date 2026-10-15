package techlearn.composite;

import techlearn.iterator.Iterator;
import techlearn.iterator.NullIterator;

public final class Aula extends ComponenteCatalogo {
    private final String nome;
    private final int duracaoMinutos;

    public Aula(String nome, int duracaoMinutos) {
        if (duracaoMinutos < 0) {
            throw new IllegalArgumentException("A duração não pode ser negativa.");
        }
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("   - Aula: " + getNome() + " (" + getDuracaoMinutos() + " min)");
    }

    @Override
    public Iterator<ComponenteCatalogo> criarIterator() {
        return new NullIterator<>();
    }
}
