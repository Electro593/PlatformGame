package com.electro593.platformGame.ui;

import java.awt.Graphics;
import java.util.Map;

import com.electro593.platformGame.TextureCache;

public class UIImage extends UIFrame
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
    private Map<String, String> attributes;
    private String textureMapKey;
    
    public UIImage(double posX, double posY, double velX, double velY, double velXMax, double velYMax, double accelX, double accelY,
                   int width, int height, String textureMapKey, Map<String, String> attributes)
    {
        super(posX, posY, velX, velY, velXMax, velYMax, accelX, accelY, width, height, null, attributes, null);
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
        setTextureMapKey(textureMapKey);
        setAttributes(attributes);
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
    }
    
    public void paint(Graphics g, double step)
    {
        g.drawImage(TextureCache.getUITexture(textureMapKey),
                    (int)(posX + ((posX - prevPosX) * step)),
                    (int)(posY + ((posY - prevPosY) * step)),
                    width, height, null);
    }
    
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
    
    public String getTextureMapKey() { return textureMapKey; }
    public void setTextureMapKey(String textureMapKey) { this.textureMapKey = textureMapKey; }
    
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
    
}