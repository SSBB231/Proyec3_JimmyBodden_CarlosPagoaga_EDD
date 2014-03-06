<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyClasses;

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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyClasses;

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
            return v1 +","+ v2;
      }

      public double getWeight()
      {
            return weight;
      }

      public String getV1()
      {
            return v1;
      }

      public String getV2()
      {
            return v2;
      }
}
>>>>>>> 4126b49a9a815f9704db59cd5e21997a9206d80b
