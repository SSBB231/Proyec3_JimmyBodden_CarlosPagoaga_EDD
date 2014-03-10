/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import MyClasses.Conjunto;
import MyClasses.MyLink;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import foreignclasses.ShortestPath;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

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

//            Graph<String, MyLink> mainGraph = new DirectedSparseMultigraph();
            Graph<String, MyLink> mainGraph = new DirectedSparseMultigraph();

            File travel = new File("./travel.txt");
            if (travel.exists())
            {
                  int contador = 0;
                  try
                  {
                        FileReader fr = new FileReader(travel);
                        BufferedReader br = new BufferedReader(fr);

                        String linea;
                        String[] arre;

                        while ((linea = (String) br.readLine()) != null)
                        {

                              arre = linea.split(",");
                              System.out.println("Probando3");
                              System.out.println("Added edge: " + mainGraph.addEdge(new MyLink(arre[1], arre[2], Double.parseDouble(arre[3])), arre[1], arre[2]));
//                              System.out.println("Added edge: " + mainGraph.addEdge(new MyLink(arre[2], arre[1], Double.parseDouble(arre[3])), arre[2], arre[1]));
                              contador++;
                              System.out.println(contador);
                        }

                        br.close();
                        fr.close();

                  } catch (Exception ex)
                  {
                        JOptionPane.showMessageDialog(null, "Error Fatal Fin del Mundo Adios");
                  }

            } else
            {
                  JOptionPane.showMessageDialog(null, "Error No Existe el archivo");
            }

            // The Layout<V, E> is parameterized by the vertex and edge types
            Layout<String, MyLink> layout = new FRLayout(mainGraph);
            layout.setSize(new Dimension(700, 700)); // sets the initial size of the space
            // The BasicVisualizationServer<V,E> is parameterized by the edge types
            BasicVisualizationServer<String, MyLink> vv = new BasicVisualizationServer(layout);
            vv.setPreferredSize(new Dimension(800, 800)); //Sets the viewing area size
            Transformer<String, Paint> trans = new Transformer<String, Paint>()
            {
                  public Paint transform(String i)
                  {
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
            //---------------------------------------------------------- Aquí se va a realizar el algoritmo ----------------------------------------
//            BruteForce bf = new BruteForce(mainGraph);
//            
//            bf.CalcBestRoute();
            //Se crea un arreglo con todos los vértices del grafo.
            
            DijkstraShortestPath p = new DijkstraShortestPath(mainGraph, new Transformer<MyLink, Double>()
            {
                  public Double transform(MyLink link)
                  {
                        return link.weight;
                  }
            }, true);
            
            
            String[] vertices;
            vertices = mainGraph.getVertices().toArray(new String[mainGraph.getVertexCount()]);

            for (int i = 0; i < vertices.length; i++)
            {
                  System.out.println(i + ") " + vertices[i]);
            }

            double[][] adjMatrix = new double[vertices.length][vertices.length];

            for (int i = 0; i < adjMatrix[0].length; i++)
            {
                  for (int j = 0; j < adjMatrix.length; j++)
                  {
                        System.out.print("[" + adjMatrix[i][j] + "]");
                  }
                  System.out.println("");
            }

            for (int i = 0; i < vertices.length; i++)
            {
                  for (int j = 0; j < vertices.length; j++)
                  {
                        if (i != j && p.getDistance(vertices[i], vertices[j]) != null)
                        {
                              adjMatrix[i][j] = (Double)p.getDistance(vertices[i], vertices[j]);
                        } else
                        {
                              adjMatrix[i][j] = -1;
                        }
                  }
            }

            System.out.println("");

            for (int i = 0; i < adjMatrix[0].length; i++)
            {
                  for (int j = 0; j < adjMatrix.length; j++)
                  {
                        System.out.print("[" + adjMatrix[i][j] + "]");
                  }
                  System.out.println("");
            }

            String ciudades = JOptionPane.showInputDialog("Ingrese las ciudades separadas por comas."
                    + "Escriba los códigos de ciudades con cuidado de la siguiente manera:"
                    + "\nEjemplo: TGU,MIA,JFK.");
            
            if(ciudades.equals(null))
            {
                  JOptionPane.showMessageDialog(frame, "La cadena es nula. El programa ahora acabará.", "Error", JOptionPane.ERROR_MESSAGE);
                  System.exit(0);
            }
            
            String[] cs = ciudades.split(",");
            
            //------------------------------------------------------------------------------
            
            Conjunto w = new Conjunto(vertices.length);
            
            boolean flag = false;
            int comienzo = 0;
            
            for (int i = 0; i < cs.length; i++)
            {
                  System.out.println(cs[i]);
                  System.out.println(vertices[i]);
                  System.out.println(cs[i].equals(vertices[i]));
                  for (int j = 0; j < vertices.length; j++)
                  {
                        if (cs[i].equals(vertices[j]))
                        {
                              System.out.println("Soy igual.");
                              w.aniadir(i);

                              if (!flag)
                              {
                                    comienzo = i;
                                    flag = true;

                                    System.out.println(comienzo);
                              }
                        }
                  }
            }
            
            //-------------------------------------------------------------------------

            for (int i = 0; i < w.cardinal(); i++)
            {
                  System.out.print("[" + w.getElementos()[i] + "]");
            }

            System.out.println("Hola.");

            ShortestPath pr = new ShortestPath();

            System.out.println("Retorno de camino(): " + pr.camino(25, comienzo, w, adjMatrix));

            for (int i = 0; i < adjMatrix[0].length; i++)
            {
                  for (int j = 0; j < adjMatrix.length; j++)
                  {
                        System.out.print("[" + adjMatrix[i][j] + "]");
                  }
                  System.out.println("");
            }
      }
}
