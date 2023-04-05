package com.example.apijavacloud.controller;

import com.example.apijavacloud.model.Produtos;
import com.example.apijavacloud.model.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produtos> listaProdutos(){
        return produtoService.listaProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produtos> listaProduto(@PathVariable int id){
        try {
            return produtoService.listaProdutoPorId(id);
        }
        catch (Exception e){
            System.out.println("Usuario nao encontrado");
            return null;
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produtos incluiProdutos(@RequestBody  Produtos produto){
        return produtoService.incluiProduto(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaProduto(@PathVariable int id){
        produtoService.excluiProduto(id);
    }

    @PutMapping("/{id}")
    public Produtos atualizarProdutos(@PathVariable int id, @RequestBody Produtos produtoAlterado){
        Produtos produtoAtual = produtoService.listaProdutoPorId(id).get();
        BeanUtils.copyProperties(produtoAlterado,produtoAtual,"id");

        return produtoService.incluiProduto(produtoAtual);
    }

}
