/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the ediv2r.
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

//      public class Road
//      {
//
//            public int v1;
//            public int v2;
//      };

      private Graph mymap;
      ArrayList<MyLink> bestroute;

      public BruteForce(Graph map)
      {
            mymap = map;
            bestroute = new ArrayList<MyLink>();
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
                  System.out.println("road " + i + " v1 " + road.v1 + " v2 " + road.v2 + " distance " + ((MyLink)this.mymap.findEdge(road.v1, road.v2)).weight);
            }
            System.out.println("");
      }

      private int TryRoutes(ArrayList<MyLink> route)
      {
            if (route.size() == this.mymap.getVertexCount() - 1)
            {
                  //Print(route);
                  if (IsBestRoute(route) == true)
                  {
                        bestroute = route;
                  }
            } 
            else
            {

                  for (int i = 0; i < this.mymap.getVertexCount(); i += 1)
                  {
                        MyLink nextroad = new MyLink();
                        
                        if (route.isEmpty() == true)
                        {
                              System.out.println("Added first nextRoad to the arraylist.");
                              nextroad.v1 = (String)this.mymap.getVertices().toArray()[0];
                              System.out.println("nextroad.v1: " + nextroad.v1);
                        } 
                        else
                        {
                              MyLink lastroad = route.get(route.size() - 1);
                              nextroad.v1 = lastroad.v2;
                        }
                        
                        nextroad.v2 = (String)this.mymap.getVertices().toArray()[i];
                        System.out.println("nextroad.v2: " + nextroad.v2);
                        //make sure we visit new cities only
                        
                        if (((String)this.mymap.getVertices().toArray()[i]).equals(nextroad.v1))
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
                  System.out.println("Bestroute: " + bestroute);
                  return true;
            } 
            else
            {
                  System.out.println("Less than RoutDistance(route).");
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
                  
                        System.out.println("Encontré el enlace...");
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
