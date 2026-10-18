import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoDeProdutos {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("Televisão", 2000.0),
                new Produto("Playstation 5",5000.0),
                new Produto("Livro",50.0),
                new Produto("Fone de ouvido",79.99),
                new Produto("Mouse",39.99));

        List<Produto> listaMaior100 = produtos.stream()
                .filter(p -> p.getPreco()>100)
                .collect(Collectors.toList());
        System.out.println("Produtos que custam mais de R$: 100,00");
        System.out.println(listaMaior100);
        System.out.println("-----------------------");
        System.out.println("Produtos em ordem alfabética ");
        List<Produto> listaOrdemAlfabetica = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome)).collect(Collectors.toList());
        System.out.println(listaOrdemAlfabetica);


        System.out.println("-----------------------");

        String nomeProcurado = "Mouse";

        Optional<Produto> resultadoProcura;

        resultadoProcura = procurarProduto(produtos,nomeProcurado);
        resultadoProcura.ifPresentOrElse(p -> {
            System.out.println("Produto Achado\nNome: "+p.getNome()+"\nPreço : R$"+p.getPreco());
        },() ->System.out.println("Produto não encontrado"));
        System.out.println("-----------------------");

        String nomeProcuradoNaoExistente = "Fruta";
        resultadoProcura =  procurarProduto(produtos,nomeProcuradoNaoExistente);


        resultadoProcura.ifPresentOrElse(p ->
        {
            System.out.println("Produto Achado\nNome: "+p.getNome()+"\nPreço : R$"+p.getPreco());
        },()-> System.out.println("Produto não encontrado"));

    }
    public static Optional<Produto> procurarProduto( List<Produto> listaProdutos, String produtoProcurado){
        return listaProdutos.stream()
                .filter(p -> p.getNome().equals(produtoProcurado))
                .findFirst();
    }
}
