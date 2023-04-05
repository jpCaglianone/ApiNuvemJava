package com.example.apijavacloud.model.service;

import com.example.apijavacloud.model.Clientes;
import com.example.apijavacloud.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    public List<Clientes> listaClientes(){
        return clienteRepository.findAll();
    }

    public Clientes incluiCliente (Clientes cliente){
        try{

            System.out.println("Cliente inserido com sucesso!");
            return clienteRepository.save(cliente);
        }
        catch (Exception e){
            System.out.println("Erro ao inserir cliente: " + e  );
            return null;
        }
    }

    public Optional<Clientes> listaClientePorId(int id){
        return clienteRepository.findById(id);
    }
    public void excluiCliente(int id){
        try {

            clienteRepository.deleteById(id);
            System.out.println("Cliente de id " + id + " excluido com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro a excluir cliente: " + e );
        }
    }

}
