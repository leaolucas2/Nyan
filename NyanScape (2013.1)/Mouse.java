import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mouse extends Actor
{
    int velocidade=3;
    int count=0;
    public void act() 
    {
        
        moveAndTurn();
        
        Actor cheese;
        cheese = getOneObjectAtOffset(0,0, Cheese.class);
        
        Actor raimbow;
        raimbow = getOneObjectAtOffset(0,10, Raimbow.class);
        
        Actor star;
        star = getOneObjectAtOffset(0,5, Star.class);
        
        Actor osso;
        osso = getOneObjectAtOffset(0,5, Osso.class);
        
        if (cheese != null)
        {
            Greenfoot.playSound("eating.wav");
            MouseWorld world=(MouseWorld)getWorld();
            world.novoCheese();
            world.removeObject(cheese);                             
        }
        
        if (raimbow != null)
        {
            
            turn(15);                         
        }
        
        if (star != null)
        {
            MouseWorld world=(MouseWorld)getWorld();
            world.removeObject(star);  
            world.powerUp();
            velocidade++;
                                    
        }
        
        if (osso != null)
        {
            MouseWorld world=(MouseWorld)getWorld();
            world.removeObject(osso); 
            world.novoDog();
            world.powerUp();
            count++;
               if((count%3)==0)
               {
                   velocidade--;
                }
        }
    }    
    
       
       
       
   
       
    public void moveAndTurn(){
         if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
           move(velocidade);
        }
        //if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        //{
        //  Greenfoot.playSound("eating.wav");
       // }
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("a"))
        {
           turn(-velocidade);
        }
        if(Greenfoot.isKeyDown("right")|| Greenfoot.isKeyDown("d"))
        {
           turn(velocidade);
        }
    }
    
      
   
           
}
