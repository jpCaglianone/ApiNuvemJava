package com.example.apijavacloud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes_c01")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    private String cep;

    private String tipo;

//    @OneToOne
//    @JoinColumn(name = "idSolicitacao")
//    private Endereco endereco;

//    @Override
//    public String toString(){
//
//        return this.getNome() + " - " + this.getTipo() + " - " + this.getCep() + " - " + this.getEndereco().getLogradouro();
//    }
//    public void adquiriEndereco(String cep) {
//        String endpoint = "https://viacep.com.br/ws/" + cep + "/json/";
//
//        try {
//            URL url = new URL(endpoint);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//
//            StringBuilder enderecoDetalhes = new StringBuilder();
//            Scanner scanner = new Scanner(url.openStream());
//            while(scanner.hasNext()){
//                enderecoDetalhes.append(scanner.nextLine());
//            }
//            scanner.close();
//
//            Gson gson = new Gson();
//            Endereco endereco = gson.fromJson(String.valueOf(enderecoDetalhes), Endereco.class);
//            setEndereco(endereco);
//            //System.out.println(endereco.getLogradouro());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
