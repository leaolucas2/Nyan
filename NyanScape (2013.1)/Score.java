import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Score extends Actor
{
    private int points = 0;
    private int count = 0;
    
    public Score()
    {               
        act();        
    }  
    
    public void act() 
    {            
        
        if (count == 0)
        {
            GreenfootImage image = new GreenfootImage("  Score: "+points +"   ",          
                                    35,
                                   new Color(0,200,200,200),
                                   new Color(255,255,255,200)); 
                                            
            setImage(image);            
        }
        
        // Redraws the score only at every 10 acts (saves CPU)
        if (count == 10)        
            count=0;
        else
            count++;        
    }    
    
    public void addScore(int newPoints)
    {
        points += newPoints;
    }
    
    public int getScore()
    {
        return points;
    }
}
