import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class osso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Osso extends Actor
{
      
    long  lastAdded = System.currentTimeMillis ();
    public void act() 
    {
          long  curTime = System.currentTimeMillis();
                  if(curTime>=lastAdded+5000)//verifica se já se passaram 5 segundos
                  {
                      MouseWorld world=(MouseWorld)getWorld();
                      world.removeObject(this);
                   }

         
    }    
}
