import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MouseWorld extends World
{
    private Score scr;
    private enum GameState{MENU,PLAYING,GAMEOVER};    
    private GameState state;
    private Button button;
    private int count=0;
    private GameOver gameOver;
    
    
    public MouseWorld()
    {    
        super(800, 600, 1); 
        prepareMenu();
        
      }
        
    private void prepareMenu()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class));
                
        // Create the menu
        button = new Button();        
        addObject(new MenuBackground(),getWidth()/2,getHeight()/2);
        addObject(button,getWidth()-60,getHeight()-60);
        
        // Set the game state
        state = GameState.MENU;
        
    }
    
    private void preparePlaying()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class));
        
        // Add score, life, and cannon actors
        Mouse mouse = new Mouse();
        addObject(mouse, 60, 521);
        Cheese cheese = new Cheese();
        addObject(cheese, 118, 238);
        Cat cat = new Cat();
        addObject(cat, 380, 40);
        scr = new Score();
        addObject(scr,70,15); 
        
        // Set the game state
        state = GameState.PLAYING;
        Greenfoot.playSound("Nyan.wav");
    }
    
    public void prepareGameOver()
    {
        // Clear the world
        Greenfoot.stop();
        removeObjects(getObjects(Actor.class)); 
      
        // Add gameover screen
        gameOver = new GameOver();
        addObject(gameOver,getWidth()/2,getHeight()/2);
        
        // Add the final score
        int fscore = scr.getScore(); 
        addObject(new FinalScore(fscore),getWidth()/2,350); 
                                
        // Set the game state
        state = GameState.GAMEOVER;           
    }

        
     public void act()
    {
        switch(state)
        {
            case MENU:
            {
                actMenu();
                break;
            }            
            case PLAYING:
            {                  
                actPlaying();   
                break;
            }            
            case GAMEOVER:
            {
                actGameOver();
                break;
            }
        }
        
               
       
    }
    
    public void actMenu()
    {
        if(Greenfoot.mouseClicked(button))
        {
            preparePlaying();
        }
    }
    
    public void actPlaying()
    {
        //por enquanto não tem nada aqui, mas nao apague!
    }
    
    public void actGameOver()
    {
        if(Greenfoot.mouseClicked(gameOver))
        {
            prepareMenu();
            
        }
    }
    
    public void novoCheese()
    {
      scr.addScore(3); 
      int x= Greenfoot.getRandomNumber(760)+20;
      int y= Greenfoot.getRandomNumber(560)+20;
      Cheese cheese2 = new Cheese();
      addObject(cheese2, x, y);
      count++;
      if((count%4)==0)
      {
          novoNyan();
    
        }
        
      if((count%10)==0)      
      {
          novoRaimbow();
          
      }
      
      if(((count%11)==0)&&((count%20)!=0))
      {
          novoStar();
      }
          
      if((count%12)==0)      
      {
          novoOsso();
          
      }
    }
    
    public void novoNyan()//adiciona um novo gato
    {
      int x= 40;
      int y= Greenfoot.getRandomNumber(560)+20;
      Cat cat2 = new Cat();
      addObject(cat2, x, y);
    }
    
    public void novoRaimbow()//adiciona um novo arco iris
    {
      int x= getWidth()/2;
      int y= Greenfoot.getRandomNumber(560)+20;
      Raimbow raimbow = new Raimbow();
      addObject(raimbow, x, y);
        
    }
    
    public void novoStar()//adiciona um novo arco iris
    {
      int x= Greenfoot.getRandomNumber(760)+20;
      int y= Greenfoot.getRandomNumber(560)+20;
      Star star = new Star();
      addObject(star, x, y);
        
    }     
    
    public void novoOsso()//adiciona um novo arco iris
    {
      int x= Greenfoot.getRandomNumber(760)+20;
      int y= Greenfoot.getRandomNumber(560)+20;
      Osso osso = new Osso();
      addObject(osso, x, y);
        
    }  
    
    public void novoDog()//adiciona um novo arco iris
    {
      int x= Greenfoot.getRandomNumber(760)+20;
      int y= 580;
      Dog dog = new Dog();
      addObject(dog, x, y);
        
    }  
    
    public void powerUp()
    {
        scr.addScore(10);
    }
}



