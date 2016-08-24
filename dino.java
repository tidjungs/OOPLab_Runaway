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
    private boolean isLeft = false;
    private int delay = 0;
    private boolean isSliding = false;
    public void act() 
    {
        boolean gameOver = ((MyWorld) getWorld()).gameOver;
        if(!gameOver){
            jump();
            checkFall();
            moving();
            crash();
            slide();
            delay--;
        } else {
            setImage(new GreenfootImage("dino_die.png"));
        }
    }
    public void slide()
    {
        if(Greenfoot.isKeyDown("shift")) {
           setImage(new GreenfootImage("dino_slide.png"));
           setLocation(getX(), 372);
           isSliding = true;
        } else {
            isSliding = false;
        }
    }
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && getY() == 358) {
            GreenfootSound jump = new GreenfootSound("jump.wav");
            jump.play();
            vSpeed = -20;
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
        Actor cactus = getOneIntersectingObject(Cactus.class);
        if(cactus != null) {
           setLocation(getX() - 40, getY());
           World world = getWorld();
           world.removeObject(cactus);
           setImage(new GreenfootImage("hurt.png"));
           delay = 20;
           GreenfootSound hurt = new GreenfootSound("hurt.wav");
           hurt.play();
        }
        Actor bird = getOneIntersectingObject(Bird.class);
        if(bird != null && !isSliding) {
           setLocation(getX() - 40, getY());
           World world = getWorld();
           world.removeObject(bird);
           setImage(new GreenfootImage("hurt.png"));
           delay = 20;
           GreenfootSound hurt = new GreenfootSound("hurt.wav");
           hurt.play(); 
        }
    }
    
}
