import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Estrela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Raimbow extends Actor
{
    long  lastAdded = System.currentTimeMillis ();
    public void act() 
    {
          long  curTime = System.currentTimeMillis();
                  if(curTime>=lastAdded+15000)//verifica se já se passaram 30 segundos
                  {
                      MouseWorld world=(MouseWorld)getWorld();
                      world.removeObject(this);
                   }

         
    }    
 

}
