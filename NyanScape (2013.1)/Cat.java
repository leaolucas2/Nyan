import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
     long  lastAdded = System.currentTimeMillis ();
    public void act() 
    {
         if(eat())
            return;
            
         moveAround();
        
         long  curTime = System.currentTimeMillis();
                  if(curTime>=lastAdded+30000)//acelera
                  {
                      move(2);
                   }
                   
                    if(curTime>=lastAdded+120000)//acelera
                  {
                      move(3);
                   }
                   
                    if(curTime>=lastAdded+360000)//acelera
                  {
                      move(4);
                   }
    }   
    
 public boolean eat(){
         Actor mouse;
        mouse = getOneObjectAtOffset(0,0, Mouse.class);
        
        Actor raimbow;
        raimbow = getOneObjectAtOffset(0,10, Raimbow.class);
        
        if (mouse != null)
        {
            MouseWorld world=(MouseWorld)getWorld();
            world.prepareGameOver();
            return true;
        }
       
        if (raimbow != null)
        {
            
            turn(15);                         
        }
        
        return false;
    }
    
 public void moveAround()
 {
     move(1);
     
     if (Greenfoot.getRandomNumber(100) < 10)
     {
        turn(Greenfoot.getRandomNumber(90) - 60);
    }
    
    if ((getX() <= 10) ||( getX() >= getWorld().getWidth() - 10))
    {
        turn(180);
    }
    
    if ((getY() <= 10) || (getY() >= getWorld().getHeight() - 10))
    {
        turn(180);
    }
    
    
}
}
 
