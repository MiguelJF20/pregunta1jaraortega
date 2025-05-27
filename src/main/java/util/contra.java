/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dto.Alumnoweb;
import java.util.List;
import javax.persistence.EntityManager;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author LENOVO
 */
public class contra {

   public static void main(String[] args) {
        System.out.println("GENERADOR DE HASHES BCRYPT");
        System.out.println("---------------------------");
        
        // Contraseñas que quieres cifrar
        String[] contraseñas = {"1234", "5678", "9876"};
        
        // Generar hash para cada contraseña
        for (String contraseña : contraseñas) {
            String hash = generarHashBcrypt(contraseña);
            System.out.println("Contraseña: " + contraseña);
            System.out.println("Hash BCrypt: " + hash);
            System.out.println("SQL para actualizar: ");
            System.out.println(generarSqlUpdate(contraseña, hash));
            System.out.println("---------------------------");
        }
    }
    
    public static String generarHashBcrypt(String contraseñaPlana) {
        // Genera un salt aleatorio y crea el hash
        return BCrypt.hashpw(contraseñaPlana, BCrypt.gensalt());
    }
    
    public static String generarSqlUpdate(String contraseñaPlana, String hash) {
        return "UPDATE AlumnoWeb SET passEstd = '" + hash + "' " +
               "WHERE passEstd = '" + contraseñaPlana + "';";
    }

}
