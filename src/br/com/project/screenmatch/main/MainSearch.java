package br.com.project.screenmatch.main;

import br.com.project.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.project.screenmatch.models.Titulo;
import br.com.project.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainSearch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme: ");
        var busca = sc.nextLine().toLowerCase();
        var buscaUri = URLEncoder.encode(busca, StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t=" + buscaUri + "&apikey=ef4dc0c8";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb pesquisaOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(pesquisaOmdb);

//        try{
            Titulo pesquisa = new Titulo(pesquisaOmdb);
            System.out.println(pesquisa);
        } catch (NumberFormatException e) {
            System.out.println("\nAconteceu o erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento, verifique o endereço enviado");
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMensagem());
        }

        System.out.println("\nFinalizou.");
    }
}