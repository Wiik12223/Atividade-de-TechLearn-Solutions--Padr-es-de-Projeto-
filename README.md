# Evidência do Passo 5

## Filtro de conteúdo curto

### Método utilizado

O método foi criado na classe `Main`:

```java
private static void listarAulasCurtas(
        ComponenteCatalogo componente,
        int limiteMinutos) {

    Iterator<ComponenteCatalogo> iterator = componente.criarIterator();

    while (iterator.hasNext()) {
        ComponenteCatalogo item = iterator.next();

        if (item instanceof Aula
                && item.getDuracaoMinutos() <= limiteMinutos) {
            item.exibirDetalhes();
        }

        listarAulasCurtas(item, limiteMinutos);
    }
}
```

O método é chamado no `main` desta forma:

```java
System.out.println("Aulas com duração menor ou igual a 45 minutos:");
listarAulasCurtas(cursoEngenharia, 45);
```

### Resultado da execução

```text
Aulas com duração menor ou igual a 45 minutos:
   - Aula: Aula 1.1: Coesão e Acoplamento (45 min)
   - Aula: Aula 2.1: Singleton na Prática (30 min)
   - Aula: Aula 2.3: Iterator para Coleções (40 min)
```

As aulas de 60 e 50 minutos não são exibidas porque ultrapassam o limite definido de 45 minutos.

## Anotação solicitada

A separação entre a estrutura do `Composite` e a lógica de percurso do `Iterator` facilitou a adição do filtro porque cada parte possui uma responsabilidade específica.

O `Composite` mantém a estrutura hierárquica do curso, organizando cursos, módulos e aulas. O `Iterator` realiza a navegação pelos componentes sem expor diretamente as coleções internas. Dessa forma, a regra do filtro foi adicionada no cliente, dentro do método `listarAulasCurtas`, sem alterar as classes `Aula`, `Modulo` ou `Iterator`.

Isso torna o código mais organizado e permite criar outros filtros futuramente, como aulas acima de determinada duração ou aulas de um módulo específico.

## Como executar

Na pasta do projeto, compile e execute:

```powershell
$src = Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $src
java -cp out techlearn.Main
```
