/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import MyClasses.MyLink;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
            File travel =new File("./travel");
            if(travel.exists())
        {
            FileInputStream entrada;
            try {
                entrada = new FileInputStream(travel);
                ObjectInputStream ruta = new ObjectInputStream(entrada);
                String linea;      
                String[] arre;
                while((linea = (String)ruta.readObject()) != null)
                {
                    arre=linea.split(",");
                    mainGraph.addEdge(new MyLink(arre[1],arre[2],Double.parseDouble(arre[3])), arre[1], arre[2]);
                }
                
                ruta.close();
                entrada.close();
                    
            } catch (Exception ex) {
                
            }
            
        }
            //Aquí se lee el archivo de texto para poder agregar todas las aristas al grafo. 
            //Esto crea, a su vez, los vértices del grafo.----------------------------------------------------------------------------------------
            
            //Se abre el archivo.
            
            //Se lee cada línea y se pone el código de la primera ciudad en una variable, el código de la segunda en otra.
            //y el costo del viaje en una tercera.
            
            //Se meten las variables (EN ORDEN) al grafo usando el siguiente código:
            //mainGraph.addEdge(new MyLink(string1, string2, weight), string1, string2);
            
            //----------------------------------------------------------------------------------------------------------------------------------------------------
      //mira hay una cosa que no estoy seguro lo que es la aereolinea no lo ocupamos o que siempre esta en el archivo de texto
      }
}
