package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    public void setTitle(String title) {
        this.title = title;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    private int ranking;

    public Linguagem() {
        
    }

    
    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }

    
    
}
