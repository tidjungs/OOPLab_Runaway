import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean isLeft = false;
    int delay = 0;
    public void act() 
    {
        moving();
        crash();
        delay--;
    }
    public void moving()
    {   
        if(delay == 0) {
            if(isLeft) { 
                setImage(new GreenfootImage("BigDinoMoveRight.png"));
                delay = 10;
                isLeft = false; 
            } else {
                setImage(new GreenfootImage("BigDinoMoveLeft.png"));
                delay = 10;
                isLeft = true;
            }
        }
    }
    public void crash()
    {
        Actor object = getOneObjectAtOffset(0,0, Object.class);
        if(object != null) {
           World world = getWorld();
           world.removeObject(object);
        }
    }
}
