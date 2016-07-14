/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadtester;

/**
 *
 * @author somebody
 */
public class ThreadTester 
{

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) 
    {
           Runnable r1 = new Runnable() {
  public void run() {
    try 
    {
      while (true) 
      {
        System.out.println("Hello, world!");
        Thread.sleep(1000L);
      }
    }  
    catch (InterruptedException iex) 
    {
      System.err.println("thread interuppted");
    }
  }
};
Runnable r2 = new Runnable() {
  public void run() {
    try {
      while (true) {
        System.out.println("Goodbye, " +
		"cruel world!");
        Thread.sleep(2000L);
      }
    } catch (InterruptedException iex) {}
  }
};
       Thread thr1 = new Thread(r1);
       Thread thr2 = new Thread(r2);
       thr1.start();
       thr2.start();
    }

}
