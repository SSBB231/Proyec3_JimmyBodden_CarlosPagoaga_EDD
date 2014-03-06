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