import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;


public class App {

    public static final String RESET = "\033[0M";

    public static void main(String[] args) throws Exception {
       // Realizar uma conexão HTTP e selecionar através do terminal o que o usuário deseja
            
        System.out.println("O que você deseja ver?");
        System.out.println("1- Top 3 filmes do IMDB\n2- 3 imagens da Nasa");
        Scanner pegarOpcao = new Scanner(System.in);
        Integer opcaoEscolhida = pegarOpcao.nextInt();

        String url = GerarUrl.setUrl(opcaoEscolhida);
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        //Escolha o Extrator
      
       ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
       //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

      //exibir e manipular os dados
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var geradora = new FabricaStickers();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
                                   
            InputStream ist = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(ist, nomeArquivo);

            System.out.println("\33[0;41m" + "Titulo: " + conteudo.getTitulo() + "\33[0;1m");
            System.out.println();
            System.out.println();
            
        }
        pegarOpcao.close();
        
    }
 
    
}
