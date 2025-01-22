/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DadosSerie;

/**
 *
 * @author User
 */
public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    
    @Override
    public <T> T ObterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
   
    
}
