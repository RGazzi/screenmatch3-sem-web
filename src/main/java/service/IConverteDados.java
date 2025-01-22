/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

/**
 *
 * @author User
 */
public interface IConverteDados {
    <T> T ObterDados(String json, Class <T> classe); //Generics - retorna tipo genérico
    
}
