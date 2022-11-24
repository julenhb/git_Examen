package com.julen.HibernateAlquilerPiso;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sesion = HibernateUtil.getSession();
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Qué operación desea realizar?");
        System.out.println("Para insertar un piso pulse 1, para reservar uno pulse 2, para borrar un piso pulse 3");
        int eleccion = entrada.nextInt();
        
        switch(eleccion) {
        case 1:
        	System.out.println("Pon un id numérico al piso");
        	int idpiso = entrada.nextInt();
        	System.out.println("Pon un id numérico a la zona del 1 al 7");
        	int idzona = entrada.nextInt();
        	System.out.println("Indica si es para Alquiler o Compra");
        	String op = entrada.next();
        	System.out.println("Indica su medida en metros cuadrados");
        	int metros = entrada.nextInt();
        	System.out.println("¿Cuál es el nombre del propietario?");
        	String nombre = entrada.next();
        	System.out.println("Necesitamos un teléfono de contacto");
        	String tlf = entrada.next();
        	
        }
        
        
        
        
        
    }
}
