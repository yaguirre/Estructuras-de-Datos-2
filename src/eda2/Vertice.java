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

public class Vertice{
  private float coordenadaX;
  private float coordenadaY;

  public Vertice(float coordenadaX,float coordenadaY){
    this.coordenadaX = coordenadaX;
    this.coordenadaY = coordenadaY;
  }

    Vertice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public float getCoordenadaX(){
    return coordenadaX;
  }

  public float getCoordenadaY(){
    return coordenadaY;
  }
}