import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object extends Actor
{
    /**
     * Act - do whatever the Object wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int movement = -5;
    public void act() 
    {
        move(movement);
        clearObject();
    }
    public void clearObject()
    {
        if(getX() == 0) {
           World world = getWorld();
           world.removeObject(this);
        }
    }
}
