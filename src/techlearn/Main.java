package techlearn;

import techlearn.composite.Aula;
import techlearn.composite.ComponenteCatalogo;
import techlearn.composite.Modulo;
import techlearn.iterator.Iterator;
import techlearn.logging.LoggerService;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        LoggerService logger = LoggerService.getInstance();
        logger.log("Iniciando montagem da estrutura de cursos...");

        Modulo cursoEngenharia = new Modulo("Engenharia de Software Moderna");

        Modulo moduloOO = new Modulo("Módulo 1: Orientação a Objetos Avançada");
        moduloOO.adicionar(new Aula("Aula 1.1: Coesão e Acoplamento", 45));
        moduloOO.adicionar(new Aula("Aula 1.2: Interfaces e Polimorfismo", 60));

        Modulo moduloPadroes = new Modulo("Módulo 2: Padrões de Projeto (GoF)");
        moduloPadroes.adicionar(new Aula("Aula 2.1: Singleton na Prática", 30));
        moduloPadroes.adicionar(new Aula("Aula 2.2: Composite Hierárquico", 50));
        moduloPadroes.adicionar(new Aula("Aula 2.3: Iterator para Coleções", 40));

        cursoEngenharia.adicionar(moduloOO);
        cursoEngenharia.adicionar(moduloPadroes);

        logger.log("Estrutura montada com sucesso. Exibindo detalhes da ementa:");
        cursoEngenharia.exibirDetalhes();

        System.out.println("\n==================================================");
        System.out.println("Varredura do Curso Principal via Iterator:");
        System.out.println("==================================================");

        Iterator<ComponenteCatalogo> iterator = cursoEngenharia.criarIterator();
        while (iterator.hasNext()) {
            ComponenteCatalogo subItem = iterator.next();
            logger.log("Navegando no Item Raiz: " + subItem.getNome()
                    + " | Duração acumulada: " + subItem.getDuracaoMinutos() + " min");
        }

        System.out.println("\nAulas com duração menor ou igual a 45 minutos:");
        listarAulasCurtas(cursoEngenharia, 45);
        logger.log("Execução da atividade finalizada.");
    }

    /** Percurso recursivo usando apenas a interface Iterator do Composite. */
    private static void listarAulasCurtas(ComponenteCatalogo componente, int limiteMinutos) {
        Iterator<ComponenteCatalogo> iterator = componente.criarIterator();
        while (iterator.hasNext()) {
            ComponenteCatalogo item = iterator.next();
            if (item instanceof Aula && item.getDuracaoMinutos() <= limiteMinutos) {
                item.exibirDetalhes();
            }
            listarAulasCurtas(item, limiteMinutos);
        }
    }
}
