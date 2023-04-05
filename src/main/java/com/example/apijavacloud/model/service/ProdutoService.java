package com.example.apijavacloud.model.service;


import com.example.apijavacloud.model.Produtos;
import com.example.apijavacloud.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produtos> listaProdutos(){
        return produtoRepository.findAll();
    }

    public Produtos incluiProduto (Produtos produto){
        try{
            System.out.println("Produto inserido com sucesso!");
            return produtoRepository.save(produto);
        }
        catch (Exception e){
            System.out.println("Erro ao inserir produto: " + e  );
            return null;
        }
    }

    public Optional<Produtos> listaProdutoPorId(int id){
        return produtoRepository.findById(id);
    }
    public void excluiProduto(int id){
        try {

            produtoRepository.deleteById(id);
            System.out.println("Produto de id " + id + " excluido com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro a excluir produto: " + e );
        }
    }


}
