import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cactus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cactus extends Actor
{
    /**
     * Act - do whatever the Cactus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        clearObject();
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

}
