package com.example.apijavacloud;

import com.example.apijavacloud.model.Produtos;
import com.example.apijavacloud.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
    @Autowired
    ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++){
            int j = i + 1;
            Produtos produto = new Produtos();
            produto.setQuantidade((i+2)*3);
            Float valor = (i+0.73f) * 43.35f;
            produto.setValor(valor);
            produto.setNome("Produto" + j);
            produto.setDescricao("Descrição do produto " + j);
            produto.setMarca("Marca" + j);
            produtoService.incluiProduto(produto);
        }
        }
    }
