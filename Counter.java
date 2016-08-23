import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int score = 0;
    private int timeLog = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.BLACK, Color.WHITE));
        addScore();
        timeLog++;
    }    
     
    public void addScore()
    {   
        if(timeLog % 100 == 0){
            score++;
        }
    }
}
