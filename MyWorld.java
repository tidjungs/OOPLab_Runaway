import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        dino dino = new dino();
        addObject(dino,68,342);
    }

    public void act()
    {
        createObject();
    }
    public void createObject()
    {
        if(Greenfoot.getRandomNumber(400) < 1 && count <= 0) {
            Object object = new Object();
            addObject(object,1200,355);
            count = 100;
        }
        count--;
        
    }
}
