package com.projetopi.hakuzanloja.controller;

import com.google.gson.Gson;
import com.projetopi.hakuzanloja.model.Endereco;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EnderecoAPI {
    public Endereco buscaCep(String cep){
        try {
            if (cep.length() > 8) {
                JOptionPane.showMessageDialog(null, "Cep invalido, por favor informe um cep com no máximo 8 caracteres");
                return null;
            }
            if (cep.isEmpty()){
                return null;
            }

            String tipoArquivo = "json";

            Gson gson = new Gson();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/" + tipoArquivo + "/"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
          

            return gson.fromJson(json, Endereco.class);
        } catch (Exception e) {
           
            return null;
        }
    }
}
