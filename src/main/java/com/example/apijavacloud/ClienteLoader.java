package com.example.apijavacloud;

import com.example.apijavacloud.model.Clientes;
import com.example.apijavacloud.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ClienteLoader implements ApplicationRunner {
    @Autowired
    ClienteService clienteService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] clientes = {"04884992","05639100","02040070","04651075","04875990","04843475","08430820","08430900","08391700","08391715"};
        for (int i = 0; i < 10; i++){
            Clientes cliente = new Clientes();
            if (i%2 == 0) {
                cliente.setTipo("Público");
            }
            else {
                cliente.setTipo("Privado");
            }
            cliente.setNome("Cliente" + i);
            cliente.setCep(clientes[i]);
//            cliente.adquiriEndereco(cliente.getCep());
//            System.out.println(cliente.toString());
            clienteService.incluiCliente(cliente);
        }

    }

}
