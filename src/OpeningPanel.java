import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OpeningPanel extends JPanel implements ActionListener{
    private BufferedImage openingBg;
    private JButton startButton;
    private JButton instructions;
    private BufferedImage blossom;
    private BufferedImage butter;
    private BufferedImage bubbles;
    private BufferedImage logo;
    private ArrayList <Coins> coins;
    private Animation runner;

    private Clip songClip;

    public OpeningPanel(JFrame frame){
        try{
            blossom = ImageIO.read(new File("src/assets/blossomOpen.png"));
            butter = ImageIO.read(new File("src/assets/butterOpen.png"));
            bubbles = ImageIO.read(new File("src/assets/bubblesOpen.png"));
            logo = ImageIO.read(new File("src/assets/logo.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<BufferedImage> runner_animation = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            String filename = "src/assets/puffbg" + i + ".gif";
            try{
                runner_animation.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        runner = new Animation(runner_animation, 66);
        coins = new ArrayList<>();
        startButton = new JButton("Start");
        instructions = new JButton("How to Play");
        add(startButton);
        add(instructions);
        startButton.addActionListener(this);
        instructions.addActionListener(this);
        playMusic();
    }

    private void playMusic(){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/assets/powerSong.wav"));
            songClip = AudioSystem.getClip();
            songClip.open(audioInputStream);
            songClip.loop(Clip.LOOP_CONTINUOUSLY);
            songClip.start();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //change font later
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(Color.yellow);
        g.drawString("Villain Breakout", 100, 45);
        g.drawImage(blossom, 250, 100, null);
        startButton.setLocation(100, 70);
        instructions.setLocation(270, 280);

       /* for(int i = 0; i < coins.size(); i++){
            Coins coin = coins.get(i);
            g.drawImage(coin.getImage(), coin.getxCoord(), coin.getyCoord(), null);

        }*/
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            if(button == startButton){
                songClip.stop();
                songClip.close();
            }
        }
    }

    private void playCoin(){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/assets/coin.wav").getAbsoluteFile());
            Clip coinClip = AudioSystem.getClip();
            coinClip.open(audioInputStream);
            coinClip.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}