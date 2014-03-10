/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreignclasses;

import MyClasses.Conjunto;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class ShortestPath
{

      ArrayList<String> path;

      public ShortestPath()
      {
            path = new ArrayList();
      }

      public double camino(int n, int i, Conjunto w, double[][] matriz)
      {
            //"w" es el conjunto de vértices que se recibirá.
            //"n" es el número de vértices del conjunto w.
            Conjunto cw = new Conjunto(w);

            //Elimina el vértice en cuestión del conjunto.
            cw.eliminar(i);

            for (int j = 0; j < cw.cardinal(); j++)
            {
                  System.out.print("[" + cw.getElementos()[j] + "]");
            }
            System.out.println("");

            if (cw.vacio())
            {
                  System.out.println("Estoy vacío.");
                  return matriz[i][0];
            } else
            {
                  System.out.println("No estoy vacío.");
            }

            double dist = Double.MAX_VALUE, dmin = Double.MAX_VALUE;

            for (int j = 0; j < n; j++)
            {
                  if (w.pertenece(j))
                  {
                        if(i != j)
                        { 
                              System.out.println("i: " + i);
                              System.out.println("j: " + j);
                              System.out.println("matriz[i][j]: " + matriz[i][j]);
                              dist = matriz[i][j] + camino(n, j, cw, matriz);
                              System.out.println("camino(): " + (dist - matriz[i][j]));
                        }

                        if (dist < dmin)
                        {
                              dmin = dist;
                        }
                  }
            }
            
            return dmin;
      }
}
