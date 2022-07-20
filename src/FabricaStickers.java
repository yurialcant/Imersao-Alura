import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class FabricaStickers {
    

    public void cria(InputStream ist, String nomeArquivo) throws IOException {
        //  leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(ist);
        
        //  criar nova imagem em memória com transparencia e com tamanho novo
       
        imagemOriginal = resizeImage(imagemOriginal, 750, 1200);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        //  copiar a imagem original pra nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte e escrever uma frase na nova imagem
        var fonte= new Font(Font.SANS_SERIF, Font.ITALIC, 86);
        graphics.setColor(Color.MAGENTA.darker());
        graphics.setFont(fonte);
        graphics.drawString("Aprovado", 70, novaAltura -100);    
                  
        //  escrever a nova imagem em um arquivo
        File figurinha = new File(nomeArquivo);
        if(figurinha.mkdir()){
            ImageIO.write(novaImagem, "png", figurinha);
        }else{
            System.out.println("Arquivo já existe no sistema");
        }
    }

    BufferedImage resizeImage(BufferedImage imagemOriginal, int larguraD, int alturaD) throws IOException{
        Image posImagem = imagemOriginal.getScaledInstance(larguraD, alturaD, Image.SCALE_SMOOTH);
        BufferedImage resultado = new BufferedImage(larguraD, alturaD, BufferedImage.TYPE_INT_RGB);
        resultado.getGraphics().drawImage(posImagem, 0, 0, null);
        return resultado;
    }

    

}
