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
public class Conjunto
{
      private int numel;
      private boolean elementos[];
      
      public Conjunto(int n)
      {
            numel = n;
            elementos = new boolean[n];
            
            for (int i = 0; i < elementos.length; i++)
            {
                  elementos[i] = false;
            }
      }
      
      public Conjunto(Conjunto a)
      {
            numel = a.cardinal();
            elementos = new boolean[a.cardinal()];
            
            for (int i = 0; i < a.cardinal(); i++)
            {
                  this.elementos[i] = a.getElementos()[i];
            }
      }
      
      public void aniadir(int i)
      {
            for (int j = 0; j < elementos.length; j++)
            {
                  if(j == i)
                  {
                        elementos[j] = true;
                  }
            }
      }
      
      public void eliminar(int n)
      {
            for (int i = 0; i < elementos.length; i++)
            {
                  if(i == n)
                  {
                        elementos[i] = false;
                  }
            }
      }
      
      public boolean pertenece(int n)
      {
            boolean pertenece = false;
            
            for (int i = 0; i < elementos.length; i++)
            {
                  if(i == n)
                  {
                        pertenece = elementos[i];
                  }
            }
            
            return pertenece;
      }
      
      public boolean vacio()
      {
            boolean vacio = true;
            
            for (int i = 0; i < elementos.length; i++)
            {
                  if(elementos[i])
                  {
                        vacio = false;
                        break;
                  }
            }
            
            return vacio;
      }

      public int cardinal()
      {
            return numel;
      }

      public void setNumel(int numel)
      {
            this.numel = numel;
      }

      public boolean[] getElementos()
      {
            return elementos;
      }

      public void setElementos(boolean[] elementos)
      {
            this.elementos = elementos;
      }
      
      
      
}
