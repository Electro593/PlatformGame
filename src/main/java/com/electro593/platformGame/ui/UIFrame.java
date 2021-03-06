package com.electro593.platformGame.ui;

import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.Map;

public class UIFrame
{
    
    private double posX;
    private double posY;
    private double prevPosX;
    private double prevPosY;
    private double velX;
    private double velY;
    private double velXMax;
    private double velYMax;
    private double accelX;
    private double accelY;
    private int width;
    private int height;
    private Color background;
    private Map<String, String> attributes;
    private List<UIFrame> elements;
    
    public UIFrame(double posX, double posY, double velX, double velY, double velXMax, double velYMax, double accelX, double accelY,
                   int width, int height, Color background, Map<String, String> attributes, List<UIFrame> elements)
    {
        setPosX(posX);
        setPosY(posY);
        setVelX(velX);
        setVelY(velY);
        setVelXMax(velXMax);
        setVelYMax(velYMax);
        setAccelX(accelX);
        setAccelY(accelY);
        setWidth(width);
        setHeight(height);
        setBackground(background);
        setAttributes(attributes);
        setElements(elements);
        prevPosX = posX;
        prevPosY = posY;
    }
    
    public void update()
    {
        prevPosX = posX;
        prevPosY = posY;
        velX += accelX;
        if (velX > velXMax)
            velX = velXMax;
        if (velX < -velXMax)
            velX = -velXMax;
        posX += velX;
        velY += accelY;
        if (velY > velYMax)
            velY = velYMax;
        if (velY < -velYMax)
            velY = -velYMax;
        posY += velY;
        
        for (UIFrame element : elements)
            element.update();
    }
    
    public void paint(Graphics g, double step)
    {
        g.setColor(background);
        g.fillRect((int)(posX + ((posX - prevPosX) * step)), (int)(posY + ((posY - prevPosY) * step)), width, height);
        for (UIFrame element : elements)
            element.paint(g, step);
    }
    
    public void setElements(List<UIFrame> elements) { this.elements = elements; }
    public void updateElement(UIFrame prev, UIFrame uiFrame) { elements.set(elements.indexOf(prev), uiFrame); }
    
    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
    
    public double getPosX() { return posX; }
    public void setPosX(double posX) { this.posX = posX; }
    
    public double getPosY() { return posY; }
    public void setPosY(double posY) { this.posY = posY; }
    
    public double getVelX() { return velX; }
    public void setVelX(double velX) { this.velX = velX; }
    
    public double getVelY() { return velY; }
    public void setVelY(double velY) { this.velY = velY; }
    
    public double getVelXMax() { return velXMax; }
    public void setVelXMax(double velXMax) { this.velXMax = velXMax; }
    
    public double getVelYMax() { return velYMax; }
    public void setVelYMax(double velYMax) { this.velYMax = velYMax; }
    
    public double getAccelX() { return accelX; }
    public void setAccelX(double accelX) { this.accelX = accelX; }
    
    public double getAccelY() { return accelY; }
    public void setAccelY(double accelY) { this.accelY = accelY; }
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    
    public Color getBackground() { return background; }
    public void setBackground(Color background) { this.background = background; }
    
}