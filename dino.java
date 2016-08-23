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
    boolean isLeft = false;
    int delay = 0;
    public void act() 
    {
        jump();
        checkFall();
        moving();
        crash();
        slide();
        delay--;
    }
    public void slide()
    {
        if(Greenfoot.isKeyDown("shift")) {
           setImage(new GreenfootImage("dino_slide.png"));
           setLocation(getX(), 372);
        }
    }
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && getY() == 358) {
            vSpeed = -25;
            fall();
        } 
   
    }
    public void fall()
    {
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
   public void moving()
    {   
        if(delay == 0) {
            if(isLeft) { 
                setImage(new GreenfootImage("dino_right.png"));
                delay = 10;
                isLeft = false; 
            } else {
                setImage(new GreenfootImage("dino_left.png"));
                delay = 10;
                isLeft = true;
            }
        }
    }
    public void crash()
    {
        Actor object = getOneIntersectingObject(Object.class);
        if(object != null) {
           setLocation(getX() - 40, getY());
           World world = getWorld();
           world.removeObject(object);
           setImage(new GreenfootImage("hurt.png"));
        }
    }
    
}
