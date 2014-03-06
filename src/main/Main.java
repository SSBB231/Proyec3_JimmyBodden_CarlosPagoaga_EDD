/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import MyClasses.MyLink;
import edu.uci.ics.jung.algorithms.layout.AggregateLayout;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.collections15.Transformer;


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
            File travel =new File("./travel.txt");
            if(travel.exists())
        {
            int contador=0;
            try {
                FileReader fr = new FileReader(travel);
                BufferedReader br = new BufferedReader(fr);
                
                
            
                String linea;      
                String[] arre;
                
                while((linea = (String)br.readLine()) != null)
                {
                    
                    arre=linea.split(",");
                    System.out.println("Probando3");
                    mainGraph.addEdge(new MyLink(arre[1],arre[2],Double.parseDouble(arre[3])), arre[1], arre[2]);
                    contador++;
                    System.out.println(contador);
                }
                
                br.close();
                fr.close();
                    
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error Fatal Fin del Mundo Adios");
            }
            
        }else{
                JOptionPane.showMessageDialog(null, "Error No Existe el archivo");
            }
            
 // The Layout<V, E> is parameterized by the vertex and edge types
 Layout<String,MyLink> layout = new FRLayout(mainGraph);
 layout.setSize(new Dimension(700,700)); // sets the initial size of the space
 // The BasicVisualizationServer<V,E> is parameterized by the edge types
 BasicVisualizationServer<String,MyLink> vv =  new BasicVisualizationServer<String,MyLink>(layout);
 vv.setPreferredSize(new Dimension(800,800)); //Sets the viewing area size
 Transformer<String,Paint> trans = new Transformer<String,Paint>(){
          public Paint transform(String i){
              return Color.CYAN;
          }
      };
 
vv.getRenderContext().setVertexFillPaintTransformer(trans);
vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
 JFrame frame = new JFrame("Simple Graph View");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().add(vv); 
 frame.pack();
 frame.setVisible(true); 

            //Aquí se lee el archivo de texto para poder agregar todas las aristas al grafo. 
            //Esto crea, a su vez, los vértices del grafo.----------------------------------------------------------------------------------------
            
            //Se abre el archivo.
            
            //Se lee cada línea y se pone el código de la primera ciudad en una variable, el código de la segunda en otra.
            //y el costo del viaje en una tercera.
            
            //Se meten las variables (EN ORDEN) al grafo usando el siguiente código:
            //mainGraph.addEdge(new MyLink(string1, string2, weight), string1, string2);
            
            //----------------------------------------------------------------------------------------------------------------------------------------------------
            //mira hay una cosa que no estoy seguro lo que es la aereolinea no lo ocupamos o que siempre esta en el archivo de texto
      
      
      ////Nasdfasdfasdf
      }
}
