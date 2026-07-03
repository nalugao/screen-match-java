package br.com.project.screenmatch.main;

import br.com.project.screenmatch.models.Titulo;
import br.com.project.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme: ");
        var busca = sc.nextLine().toLowerCase().replaceAll(" ", "+");
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=ef4dc0c8";

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

        Titulo pesquisa = new Titulo(pesquisaOmdb);
        System.out.println(pesquisa);

    }
}