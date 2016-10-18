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

public class Graph{
  private Hashtable<Integer,Vertice> vertices;
  private Hashtable<Integer,Hashtable<Integer,Arco>> graph;
  public int size;

  public Graph(String archivo) throws Exception{
    vertices = new Hashtable<>();
    graph = new Hashtable<>();
    lectura(archivo);
  }

  /**
   * 
   * @param archivo
   * @throws Exception 
   */
  public void lectura(String archivo) throws Exception{
    Scanner lector = new Scanner(new File(archivo));
    lector.nextLine();  // No necesitamos leer la primera linea porque ya sabemos que nos pasan primero los vertices
    String cadena;
    int id,source,destination;
    float coordenadaX,coordenadaY,distance;
    boolean sonVertices = true;
    while(lector.hasNext()){
      cadena = lector.next();
      if(sonVertices && !cadena.equals("Arcos.")){
        id = Integer.parseInt(cadena);
        cadena = lector.next();
        coordenadaX = Float.parseFloat(cadena);
        cadena = lector.next();
        coordenadaY = Float.parseFloat(cadena);
        vertices.put(id,new Vertice(coordenadaX,coordenadaY));
        graph.put(id,new Hashtable());
        size++;
        lector.nextLine();
      }else if(sonVertices && cadena.equals("Arcos.")){
      	sonVertices = false;
        lector.nextLine();
        cadena = lector.next();
        if(cadena.isEmpty()){
          lector.nextLine();
          cadena = lector.next();
        }
      }
      if(!sonVertices){
        source = Integer.parseInt(cadena);
        cadena = lector.next();
        destination = Integer.parseInt(cadena);
        cadena = lector.next();
        distance = Float.parseFloat(cadena);
        cadena = lector.next();
        graph.get(source).put(destination,new Arco(distance,cadena));
        lector.nextLine();
      }
    }
    lector.close();
  }
  
  /**
   * Método que devuelve la distancia entre un par de nodos
   * @param source
   * @param destination
   * @return 
   */
  public float getWeight(int source, int destination){
      return graph.get(source).get(destination).getDistance();
  }
  
  /**
   * Método que retorna el tamaño del grafo
   * @return 
   */
  public int getSize(){
      return size;
  }
  
  /**
   * Método que devuelve los sucesores de un vertice
   * @param vertice
   * @return 
   */
  public ArrayList<Integer> getSuccessors(int vertice){
    ArrayList<Integer> sucesores = new ArrayList<>();
    for(Integer sucesor : graph.get(vertice).keySet())
        sucesores.add(sucesor);
    return sucesores;
  }
  
}
