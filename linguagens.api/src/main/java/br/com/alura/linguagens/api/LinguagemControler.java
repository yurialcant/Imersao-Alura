package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemControler {
    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguas")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }
    
    @PostMapping("/linguas")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemsalva = repositorio.save(linguagem);
        return linguagemsalva;
    }

    @PutMapping("/linguas")
    public ResponseEntity<Linguagem> atualizarLingua(@PathVariable String id, @RequestBody Linguagem linguagem){
        Linguagem novaLinguagem = repositorio.findById(id).orElseThrow();

        novaLinguagem.setTitle(linguagem.getTitle());
        novaLinguagem.setImage(linguagem.getImage());
        novaLinguagem.setRanking(linguagem.getRanking());

        repositorio.save(novaLinguagem);
        return ResponseEntity.ok(novaLinguagem);
    }

    @DeleteMapping("/linguas")
    public String apagarLinguagem(@PathVariable String id){
        repositorio.deleteById(id);
        return "Deletado com sucesso!";
    }

}
