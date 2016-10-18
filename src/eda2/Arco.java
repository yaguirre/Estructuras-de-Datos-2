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

/**
 * 
 * @author YormanAndres
 */
public class Arco{
  public String nombre;
  public float distance;

  public Arco(float distance, String nombre){
    this.distance = distance;
    this.nombre = nombre;
  }

  public String getNombre(){
    return nombre;
  }

  public float getDistance(){
    return distance;
  }
}
