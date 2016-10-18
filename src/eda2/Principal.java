/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda2;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *@author Yorman Aguirre
 *@author Sebastian Ramirez
 *@version 27/09/2016 1.0
 */

public class Principal{
  
  /**
   * Método principal
   * @param args 
   */  
  public static void main(String[] args) {
    //Primero debemos leer el archivo de entrada
    try{
      newGraph("C:\\Users\\YormanAndres\\Desktop\\Entrega #2\\ejemplo-de-entrada-salida-entrega2\\Ejemplo-entrada-salida-entrega2\\grafo-inventado-de-ejemplo.txt");
      
    }catch(Exception e){
        System.out.println("Exception Generated: " + e.getMessage());
    }
  }

  /**
   * Método auxiiar para la creación del grafo y pedirle al usuario el URL
   * @param archivo
   * @throws Exception 
   */
  public static void newGraph(String archivo) throws Exception{
    Graph g = new Graph(archivo);
    ArrayList<Integer> vertices = new ArrayList<>();
    System.out.println("Ingrese el URL: ");
    Scanner sc = new Scanner(System.in);
    String url = sc.nextLine();
    String[] coordenadas;
    while(url.isEmpty())
        url = sc.nextLine();
    url = url.substring(30,url.length()).replace(',', '/');
    coordenadas = url.split("/");
    coordenadas[coordenadas.length-2] = coordenadas[coordenadas.length-2].substring(1);
    vertices = obtenerVertices(coordenadas,coordenadas.length);
   // System.out.println(url);
  }
  
  /**
   * Método utilizado para convertir el arreglo de string que contiene las coordenadas en un arreglo de float
   * y retornar un ArrayList con los correspoendientes vertices a los cuales hacen referencia las coordenadas
   * @param coordenadas
   * @param size
   * @return 
   */
  public static ArrayList<Integer> obtenerVertices(String[] coordenadas, int size){
      ArrayList<Integer> vertices = new ArrayList<>();
      float[] coordenadasVertices = new float[size];
      for(int i = 1; i < size;i++){ 
        coordenadasVertices[i-1] = Float.parseFloat(coordenadas[i]);
        System.out.println(coordenadasVertices[i-1]);
      }
      return vertices;
  }
}

