import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dino extends Actor
{
    /**
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    private int vSpeed = 0;
    private int acceleration = 1;
    public void act() 
    {
        jump();
        checkFall();
    }
    public void jump()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            if(vSpeed == 0) {
                vSpeed = -8;
            }
           
        }
   
    }
    public void fall()
    {
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    public void checkFall()
    {
        if (getY() == getWorld().getWidth())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
   }
    
}
