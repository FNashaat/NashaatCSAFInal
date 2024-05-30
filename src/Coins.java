import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Coins {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Coins(int x, int y){
        xCoord = x;
        yCoord = y;
        try{
            image = ImageIO.read(new File("src/coin.png"));
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord(){
        return xCoord;
    }

    public int getyCoord(){
        return xCoord;
    }

    public BufferedImage getImage(){
        return image;
    }


    public Rectangle coinRect(){
        int imageH = getImage().getHeight();
        int imageW = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageW, imageH);
        return rect;
    }

}
