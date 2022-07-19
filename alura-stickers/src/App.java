import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {

    public static final String RESET = "\033[0M";

    public static void main(String[] args) throws Exception {
       // fazer uma conexão HTTP e buscar os top 250 filmes
       


        //String url = "https://api.mocki.io/v2/549a5d8b";
        System.out.println("O que você deseja ver?");
        System.out.println("1- Top250 Filmes\n2- top 250 Series");
        Scanner pegarOpcao = new Scanner(System.in);
        Integer opcaoEscolhida = pegarOpcao.nextInt();

        String url = GerarUrl.setUrl(opcaoEscolhida);

        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\33[0;41m" + "Titulo: " + filme.get("title") + "\33[0;1m");
            System.out.println(filme.get("image"));
            System.out.println("\033[44m" + "Avaliação: " + filme.get("imDbRating") + "\033[0;1m");
            System.out.println();
            
        }
    }
 
    
}
