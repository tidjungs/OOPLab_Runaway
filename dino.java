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
     
    int vSpeed = 0;
    int acceleration = 1;
    public void act() 
    {
        jump();
        checkFall();
    }
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && getY() == 358)
        {
            vSpeed = -25;
            fall();
        }
   
    }
    public void fall()
    {
        //System.out.println(getY());
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    public void checkFall()
    {
        if (getY() >= 358) {
            vSpeed = 0;
            setLocation(getX(), 358);
        }
        else {
            fall();
        }
   }
    
}
