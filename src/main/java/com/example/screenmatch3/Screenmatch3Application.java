package com.example.screenmatch3;

import java.util.ArrayList;
import java.util.List;
import model.DadosEpisodio;
import model.DadosSerie;
import model.DadosTemporada;
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
        
        //serie
        var consumoApi = new ConsumoAPI();
        String endereco = "https://www.omdbapi.com/?t=gilmore_girls&apikey=2d6d31ff"; //"https://www.omdbapi.com/?t=gilmore_girls&Season=1&apikey=2d6d31ff";
        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        //json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
        //System.out.println(json);
        
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.ObterDados(json, DadosSerie.class);
        System.out.println(dados);
        
        //temporada
        String enderecoTemporada = "https://www.omdbapi.com/?t=gilmore_girls&season=1&apikey=2d6d31ff";
        json = consumoApi.obterDados(enderecoTemporada);
        DadosTemporada dadosTemporada = conversor.ObterDados(json, DadosTemporada.class);
        System.out.println(dadosTemporada);
        
        //Percorrer temporadas
        List<DadosTemporada> listaTemporadas = new ArrayList<>();
        
        for(int i = 1; i<=dados.totalTemporadas(); i++){  
          json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore_girls&season=" + i + "&apikey=2d6d31ff");
          DadosTemporada dadosTemporada2 = conversor.ObterDados(json, DadosTemporada.class);
          listaTemporadas.add(dadosTemporada2);
        }
        listaTemporadas.forEach(System.out::println);
        
        //Episódio
        String enderecoEpisodio = "https://www.omdbapi.com/?t=gilmore_girls&season=1&episode=2&apikey=2d6d31ff";
        json = consumoApi.obterDados(enderecoEpisodio);
        DadosEpisodio dadosEpisodio = conversor.ObterDados(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);
        
    }
    

}
