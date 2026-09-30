/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
/**
 * Herramienta de encriptación para la contraseña de los usuarios
 * @author jdani
 */
public class Encriptacion {
    
    public static String encriptarPass(String passwordPlana){
        if(passwordPlana == null || passwordPlana.trim().isEmpty()){
            return null; 
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            byte[] hash = digest.digest(passwordPlana.getBytes()); 
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash){
                String hex = Integer.toHexString(0xFF & b); 
                if(hex.length() == 1) hexString.append('0'); 
                hexString.append(hex);
            }
            return hexString.toString();   
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error al encriptar contraseña" + e.getMessage()); 
        }
    }
    
    
    
    
    
}
