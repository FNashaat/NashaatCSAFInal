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

public class OpeningPanel extends JPanel implements ActionListener{
    private BufferedImage openingBg;
    private JButton startButton;
    private JButton instructions;
    private BufferedImage blossom;
    private BufferedImage butter;
    private BufferedImage bubbles;
    private BufferedImage logo;

    private Clip songClip;

    public OpeningPanel(JFrame frame){
        try{
            openingBg = ImageIO.read(new File("src/puffbg.gif"));
            blossom = ImageIO.read(new File("src/assets/blossom.png"));
            butter = ImageIO.read(new File("src/assets/butter.png"));
            bubbles = ImageIO.read(new File("src/assets/bubbles.png"));
            logo = ImageIO.read(new File("src/assets/logo.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(""))
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
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            if(button == startButton){

            }
        }
    }


}