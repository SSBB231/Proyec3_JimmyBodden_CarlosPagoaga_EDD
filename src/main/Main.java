/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import MyClasses.MyLink;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;

/**
 *
 * @author danny
 */
public class Main
{
      public static void main(String[] args)
      {
            //Crea el grafo para que maneje vértices de tipo String y aristas de tipo MyLink.
            Graph<String, MyLink> mainGraph = new DirectedSparseMultigraph();
            
            //Aquí se lee el archivo de texto para poder agregar todas las aristas al grafo. 
            //Esto crea, a su vez, los vértices del grafo.----------------------------------------------------------------------------------------
            
            //Se abre el archivo.
            
            //Se lee cada línea y se pone el código de la primera ciudad en una variable, el código de la segunda en otra.
            //y el costo del viaje en una tercera.
            
            //Se meten las variables (EN ORDEN) al grafo usando el siguiente código:
            //mainGraph.addEdge(new MyLink(string1, string2, weight), string1, string2);
            
            //----------------------------------------------------------------------------------------------------------------------------------------------------
      }
}
