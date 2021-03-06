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
    private int count = 0;
    private int stage = 100;
    private int timeLogger = 0;
    private int cactusSpeed = -4;
    private boolean gameOver = false;
    private int gameOverCount = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        prepare();
        changeStage();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        dino dino = new dino();
        addObject(dino,700,358);
        Boss boss = new Boss();
        addObject(boss,180,242);
        Counter counter = new Counter();
        addObject(counter,994,68);
        counter.setLocation(973,59);
    }

    public void act()
    {
        if(!gameOver) {
            createObject();
            changeStage();
            timeLogger++;
        } else {
            Gameover go = new Gameover();
            addObject(go,600,200);
            gameOverCount++;
        }
        
        if(gameOverCount > 100) {
           Greenfoot.stop();
        }
    }
    public void createObject()
    {
        if(Greenfoot.getRandomNumber(stage) < 1 && count <= 0) {
            if(Greenfoot.getRandomNumber(2) == 0) {
                Cactus cactus = new Cactus();
                addObject(cactus,1200,370);
            } else {
                Bird bird = new Bird();
                addObject(bird,1200,300);
            }
            count = 100;
        }
        count--;
        
    }
    public void changeStage()
    {
        if(timeLogger % 1000 == 0) {
            cactusSpeed--;
        }
    }
    public int getCactusSpeed()
    {
        return cactusSpeed;
    }
    public void gameIsOver()
    {
        gameOver = true;
    }
    public boolean isGameOver()
    {
        return gameOver;
    }
}
