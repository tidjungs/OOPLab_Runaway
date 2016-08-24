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
    private boolean isLeft = false;
    private int delay = 0;
    public void act() 
    {
        boolean gameOver = ((MyWorld) getWorld()).gameOver;
        if(!gameOver) {
            moving();
            crash();
            delay--;
        } else {
            setImage(new GreenfootImage("BigDino.png"));
            setRotation(45);
        }
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
        Actor cactus = getOneIntersectingObject(Cactus.class);
        if(cactus != null) {
           World world = getWorld();
           world.removeObject(cactus);
        }
        
        Actor dino = getOneIntersectingObject(dino.class);
        if(dino != null) {
           ((MyWorld) getWorld()).gameOver = true;
           GreenfootSound gameover = new GreenfootSound("scream.wav");
           gameover.play();
        }
    }
}
