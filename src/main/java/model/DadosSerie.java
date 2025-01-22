package model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie (@JsonAlias ({"title", "Title"})String titulo,//@JsonAlias ({"title", "Titulo"})String titulo, 
                          @JsonAlias ("totalSeasons") Integer totalTemporadas, 
                          @JsonAlias ("imdbRating") String avaliacao ){
                          //@JsonProperty ("imdbVotes") String votos) //também escreve o original 
    
}
