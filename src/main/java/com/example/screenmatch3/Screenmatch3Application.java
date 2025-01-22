package com.example.screenmatch3;

import model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoAPI;
import service.ConverteDados;

@SpringBootApplication
public class Screenmatch3Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch3Application.class, args);
               
	}

    @Override
    public void run(String... args) throws Exception { //Função do método MAIN
        var consumoApi = new ConsumoAPI();
        String endereco = "https://www.omdbapi.com/?t=gilmore_girls&apikey=2d6d31ff"; //"https://www.omdbapi.com/?t=gilmore_girls&Season=1&apikey=2d6d31ff";
        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        //json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
        //System.out.println(json);
        
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.ObterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
    

}
