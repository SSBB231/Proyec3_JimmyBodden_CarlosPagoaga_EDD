/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PersonalizedDataStructures;

/**
 *
 * @author danny
 */
public class MyLink
{
      public double weight;
      public String v1;
      public String v2;
      
      public MyLink(String a, String b, double weight)
      {
            v1 = a;
            v2 = b;
            this.weight = weight;
      }
      
      @Override
      public String toString()
      {
            return v1 +", "+ v2;
      }
}
