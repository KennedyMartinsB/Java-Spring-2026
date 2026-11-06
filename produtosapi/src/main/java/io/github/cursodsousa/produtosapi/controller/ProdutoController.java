package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido!!!" + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterPorId(@PathVariable String id){
        Produto produto = produtoRepository.findById(id).orElse(null);

        if(produto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if(produto == null){
            return ResponseEntity.notFound().build();
        }

        produtoRepository.delete(produto);
        return ResponseEntity.noContent().build();
    }
}
