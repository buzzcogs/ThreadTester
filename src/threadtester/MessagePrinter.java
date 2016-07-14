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
public class MessagePrinter implements Runnable 
{
  private final String message;
  private final long interval;
  private volatile boolean stopRequested = false;

  public MessagePrinter(String msg, long interval) 
  {
    this.message = msg;
    this.interval = interval;
  }
  public void run() 
  {
     int i = 0;
    try 
    {
      while (!stopRequested)
      {
        System.out.print(message + " ");
        System.out.println(new RandomGenerator().randomNumber());
        Thread.sleep(interval);
        i++;
        if (i>20)
        {
            System.out.println(message + " request stop "+i);
            requestStop();
        }
      }
    } 
     catch (InterruptedException iex) 
     {
      System.err.println("Message printer interrupted");
    }
  }
  

public void requestStop() 
{
  stopRequested = true;
}
  
  public static void main (String args[])
  {
       Thread thr1 = new Thread(new MessagePrinter("wazzup?", 1100L));
       Thread thr2 = new Thread(new MessagePrinter("hey now!", 867L));
       thr1.start();
       thr2.start();
  }
}
