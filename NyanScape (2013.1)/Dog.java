import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog extends Actor
{
    long  lastAdded = System.currentTimeMillis ();
    public void act() 
    {
        if(eat())
            return;
            
        moveAround();  
        long  curTime = System.currentTimeMillis();
                  if(curTime>=lastAdded+30000)//verifica se já se passaram 30 segundos
                  {
                      MouseWorld world=(MouseWorld)getWorld();
                      world.removeObject(this);
                   }
         

         
    }    
    
     public void moveAround()
     {
        move(4);
     
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90) - 60);
        }
    
        if ((getX() <= 10) ||( getX() >= getWorld().getWidth() - 10))
        {
            turn(160);
        }
    
        if ((getY() <= 10) || (getY() >= getWorld().getHeight() - 10))
        {
            turn(160);
        }
     }
     
      public boolean eat(){
        Actor cat;
        cat = getOneObjectAtOffset(0,0, Cat.class);
                
        if (cat != null)
        {
            MouseWorld world=(MouseWorld)getWorld();
            world.removeObject(cat);
            return true;
        }
               
        return false;
    }
}
