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
public class RandomGenerator 
{

  private long x = System.nanoTime();

  public synchronized long randomNumber() {
    x ^= (x << 21);
    x ^= (x >>> 35);
    x ^= (x << 4);
    return x;
  }
}
