import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{
    /**
     * Act - do whatever the bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delay = 0;
    boolean wingUp = false;
    public void act() 
    {
        movement();
        clearObject();
        moving();
        delay--;
    }
    public void clearObject()
    {
        if(getX() == 0) {
           World world = getWorld();
           world.removeObject(this);
        }
    }
    public void movement()
    {  
        int speed = ((MyWorld) getWorld()).getCactusSpeed();
        move(speed);
    }
    public void moving()
    {   
        if(delay == 0) {
            if(wingUp) {
                setImage(new GreenfootImage("bird_wingDown.png"));
                delay = 20;
                wingUp = false; 
            } else {
                setImage(new GreenfootImage("bird_wingUp.png"));
                delay = 20;
                wingUp = true;
            }
        }
    }
}
