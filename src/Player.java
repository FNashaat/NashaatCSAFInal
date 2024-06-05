import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Player {
    private final double MOVE_AMT = 0.6;
    private BufferedImage right;
    private boolean facingRight;
    private double xCoord;
    private double yCoord;
    private int score;
    private String name;
    private Animation run;
    private Animation runner;

    public Player(String rightImg, String name) {
        this.name = name;
        facingRight = true;
        xCoord = 50; // starting position is (50, 435), right on top of ground
        yCoord = 435;
        score = 0;
        try {
            right = ImageIO.read(new File(rightImg));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //The code below is used to programatically create an ArrayList of BufferedImages to use for an Animation object
        //By creating all the BufferedImages beforehand, we don't have to worry about lagging trying to read image files during gameplay

        //Easy level villain: steve animation -> fireball
        ArrayList<BufferedImage> run_animation = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            String filename = "src/steve" + i + ".png";
            try {
                run_animation.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        run = new Animation(run_animation,66);


//TO-DO mojo(if there's a better sprite
       /* ArrayList<BufferedImage> mojo_animation = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String filename = "src/him" + i + ".png";
            try {
                mojo_animation.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        runner = new Animation(mojo_animation,66);

        */


        //hard level villain: HIM animation shooting
        ArrayList<BufferedImage> him_animation = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String filename = "src/him" + i + ".png";
            try {
                him_animation.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        runner = new Animation(him_animation,66);



        ArrayList<BufferedImage> himtele_animation = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String filename = "src/himtele" + i + ".png";
            try {
                himtele_animation.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        runner = new Animation(himtele_animation,66);
    }


    //This function is changed from the previous version to let the player turn left and right
    //This version of the function, when combined with getWidth() and getHeight()
    //Allow the player to turn without needing separate images for left and right
    public int getxCoord() {
        if (facingRight) {
            return (int) xCoord;
        } else {
            return (int) (xCoord + (getPlayerImage().getWidth()));
        }
    }

    public int getyCoord() {
        return (int) yCoord;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 920) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 435) {
            yCoord += MOVE_AMT;
        }
    }

    public void turn() {
        if (facingRight) {
            faceLeft();
        } else {
            faceRight();
        }
    }

    public void collectCoin() {
        score++;
    }

    public BufferedImage getPlayerImage() {
        return run.getActiveFrame();
    }

    //These functions are newly added to let the player turn left and right
    //These functions when combined with the updated getxCoord()
    //Allow the player to turn without needing separate images for left and right
    public int getHeight() {
        return getPlayerImage().getHeight();
    }

    public int getWidth() {
        if (facingRight) {
            return getPlayerImage().getWidth();
        } else {
            return getPlayerImage().getWidth() * -1;
        }
    }

    // we use a "bounding Rectangle" for detecting collision
    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
