package entity;
import main.GamePanel;
import main.KeyInput;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyInput keyI;

    public Player(GamePanel gp, KeyInput keyI) {
        this.gp = gp;
        this.keyI = keyI;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/tom-down1-pixilart.png/"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/tom-down2-pixilart.png/"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/tom-up1-pixilart.png/"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/tom-up2-pixilart.png/"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/tom-left1-pixilart.png/"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/tom-left2-pixilart.png/"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/tom-right1-pixilart.png/"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/tom-right2-pixilart.png/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyI.upPressed == true || keyI.downPressed == true ||
                keyI.leftPressed == true || keyI.rightPressed == true) {

            if (keyI.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyI.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyI.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyI.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2D) {

        BufferedImage image = null;

        if (direction == "up") {
            if (spriteNum == 1) {
                image = up1;
            } if (spriteNum == 2) {
                    image = up2;
                }
            }
         else if (direction == "down") {
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }
        } else if (direction == "left") {
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
        } else if (direction == "right") {
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }
        }
        g2D.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}



