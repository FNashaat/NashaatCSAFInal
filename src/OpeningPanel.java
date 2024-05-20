import javax.imageio.ImageIO;
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

    public OpeningPanel(JFrame frame){
        try{
            openingBg = ImageIO.read(new File("src/puffbg.gif"));
            blossom = ImageIO.read(new File())
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        startButton = new JButton("Start");
        instructions = new JButton("How to Play");
        add(startButton);
        add(instructions);
        startButton.addActionListener(this);
        instructions.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //change font later
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(Color.yellow);
        g.drawString("Villain Breakout", 100, 100);


    }


}