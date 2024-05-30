import javax.swing.*;
public class Frame {
    private OpeningPanel frame;

    public Frame(){
        JFrame frames = new JFrame("Powerpuff Girls: Villain Breakout");
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames.setSize(450, 350);
        frames.setLocationRelativeTo(null);

        frame = new OpeningPanel(frames);
        frames.add(frame);

        frames.setVisible(true);
    }
}
