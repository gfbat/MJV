# Sobre a interface Set
Interface que representa grupos de elementos únicos, ou seja, são usados quando o programador não quer permitir elementos duplicados na coleção. 

### Características da interface Set
- Velocidade na pesquisa de dados, sendo mais rápida que um objeto do tipo List;
- A inserção de dados é mais lenta;
- Permite trabalhar com conjuntos e pode ser implementado como instâncias das classes HashSet ou TreeSet;
- Não precisa especificar a posição para adicionar um elemento;
- Não aceita valores duplicados. Se caso inserir um registro que já tenha no Set, o mesmo não será adicionado.

### Exemplo de implementação da interface Set

```java
import java.util.*;

public class ListaAluno {

  public static void main(String[] args) {
    Set<Aluno> setAlunos = new HashSet<Aluno>();

    Aluno a = new Aluno("Bruce Wayne");   
    Aluno b = new Aluno("Jason Todd");
    Aluno c = new Aluno("Bruce Wayne");
    Aluno d = new Aluno("Selina Kyle");
    setAlunos.add(a);
    setAlunos.add(b);
    setAlunos.add(c);
    setAlunos.add(d);
    System.out.println(setAlunos);
  }
}
```

### Hierarquia da interface Set

Segue abaixo a hierarquia da interface Set, junto com algumas características das implementações mais comuns.

<p align="center">
  <img src="https://user-images.githubusercontent.com/85207898/124371727-e873c280-dc5a-11eb-914e-f005072d26e8.png" />
</p>


- HashSet – o acesso aos dados é mais rápido que em um TreeSet, mas não garante que os dados estarão ordenados. Este conjunto deve ser utilizado quando a solução exigir elementos únicos e a ordem não for importante. Esta implementação poderia ser usada para criar um catálogo pessoal de canções de uma discografia, por exemplo.
- TreeSet – os dados são classificados, mas o acesso é mais lento que em um HashSet. Se a necessidade for um conjunto com elementos não duplicados e acesso em ordem natural, o TreeSet é uma ótima opção. É recomendado utilizar esta coleção para as mesmas aplicações de HashSet, com a vantagem dos objetos estarem em ordem natural.
- LinkedHashSet – é derivada de HashSet, mas mantém uma lista duplamente ligada através de seus itens. Seus elementos são iterados na ordem em que foram inseridos. Opcionalmente é possível criar um LinkedHashSet que seja percorrido na ordem em que os elementos foram acessados na última iteração. Poderíamos usar esta implementação para registrar a chegada dos corredores de uma maratona, por exemplo.
