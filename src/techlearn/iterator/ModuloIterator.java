package techlearn.iterator;

import techlearn.composite.ComponenteCatalogo;

import java.util.List;

public final class ModuloIterator implements Iterator<ComponenteCatalogo> {
    private final List<ComponenteCatalogo> itens;
    private int posicao;

    public ModuloIterator(List<ComponenteCatalogo> itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        return posicao < itens.size() && itens.get(posicao) != null;
    }

    @Override
    public ComponenteCatalogo next() {
        if (!hasNext()) {
            return null;
        }
        return itens.get(posicao++);
    }
}
