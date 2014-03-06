/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreignclasses;

import MyClasses.MyLink;
import edu.uci.ics.jung.graph.Graph;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class BruteForce
{
      
      /*
      * BruteForce es una clase bajada de la Internet pero modificada por nosotros para utilizar 
      * MyLink en vez de Road al crear una nueva ruta.
      */

      //This class isn't necessary.
//      public class Road
//      {
//            public int from;
//            public int to;
//      };

      private Graph mymap;
      ArrayList<MyLink> bestroute;

      public BruteForce(Graph map)
      {
            mymap = map;
            bestroute = new ArrayList();
      }

      public boolean CalcBestRoute()
      {
            ArrayList<MyLink> route = new ArrayList();
            TryRoutes(route);

            return true;
      }

      public void Print()
      {
            System.out.print("Best ");
            Print(this.bestroute);
      }

      public void Print(ArrayList<MyLink> route)
      {
            System.out.println("Route Distance: " + RouteDistance(route));
            System.out.println("=======================================================");
            for (int i = 0; i < route.size(); i += 1)
            {
                  MyLink road = route.get(i);
                  System.out.println("road " + i + " from " + road.v1 + " to " + road.v2 + " distance " + ((MyLink)this.mymap.findEdge(road.v1, road.v2)).weight);
            }
            System.out.println("");
      }

      private int TryRoutes(ArrayList<MyLink> route)
      {
            if (route.size() == this.mymap.getVertexCount()-1)
            {
                  //Print(route);
                  if (IsBestRoute(route) == true)
                  {
                        bestroute = route;

                  }
            } else
            {

                  for (int i = 0; i < this.mymap.getVertexCount(); i += 1)
                  {
                        MyLink nextroad = new MyLink();
                        if (route.isEmpty() == true)
                        {
                              nextroad.v1 = (String)mymap.getVertices().toArray()[0];
                        } 
                        else
                        {
                              MyLink lastroad = route.get(route.size() - 1);
                              nextroad.v1 = lastroad.v2;
                        }
                        nextroad.v1 = (String)mymap.getVertices().toArray()[i];
                        //make sure we visit new cities only
                        if (((String)mymap.getVertices().toArray()[i]).equals(nextroad.v1))
                        {
                              continue;
                        }
                        if (CityIsOnRoute(route, nextroad.v2))
                        {
                              continue;
                        }
                        ArrayList<MyLink> testroute = new ArrayList<MyLink>(route);
                        testroute.add(nextroad);
                        TryRoutes(testroute);
                  }
            }
            return 0;
      }

      private boolean IsBestRoute(ArrayList<MyLink> route)
      {
            if (RouteDistance(this.bestroute) > RouteDistance(route))
            {
                  return true;
            } else
            {
                  return false;
            }
      }

      private int RouteDistance(ArrayList<MyLink> route)
      {
            int distance = 0;

            if (route.isEmpty() == true)
            {
                  return java.lang.Integer.MAX_VALUE;
            }

            for (int i = 0; i < route.size(); i += 1)
            {
                  MyLink road = route.get(i);
                  distance += ((MyLink)this.mymap.findEdge(road.v1, road.v2)).weight;
            }
            return distance;
      }

      private boolean CityIsOnRoute(ArrayList<MyLink> route, String city)
      {
            for (int i = 0; i < route.size(); i += 1)
            {
                  MyLink road = route.get(i);
                  if (road.v1.equals(city) || road.v2.equals(city))
                  {
                        return true;
                  }
            }
            return false;
      }
}
